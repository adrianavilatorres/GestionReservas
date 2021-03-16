# Repaso disparadores

La sintaxis para crear un disparador es la siguiente:

```sql
CREATE TRIGGER nombre_disparador
  [BEFORE|AFTER] [INSERT|DELETE|UPDATE|...]
  ON nombre_tabla FOR EACH ROW
  BEGIN
    [cuerpo del disparador]
  END;
```

## Ejemplo 1: No más de una reserva al día por persona

Sea el dominio del proyecto (gestión de reservas), imaginemos que no queremos delegar sólo en el código de la aplicación que se pueda reservar más de una vez por usuario (si esta condición la incluimos en la base de  datos, será más segura, será mucho más difícil que un usuario malintencionado pueda romperla).

La alternativa es crear un disparador que primero compruebe si ya tenemos reservas en el día que vamos a insertar la nueva reserva:

```sql
SELECT COUNT(*) FROM `reserva` WHERE `reserva`.`fecha` = NEW.`fecha`
```

Fíjate en el prefijo "NEW.", en los disparadores, recuerda que esto sirve para acceder a la nueva tupla que queremos insertar, seguido de un punto y luego el nombre de cada columna para acceder al valor.

Antes de insertar una nueva reserva **BEFORE INSERT**, para cada tupla que vamos a insertar **FOR EACH ROW** comprobamos con un **IF** si ya había más de una reserva ese día para un usuario dado. Si ya la había, no procedemos a la inserción y devolvemos un mensaje de error *'sólo se permite una reserva al día'*, con código de error *45001* (este código nos lo devuelve MySQL cuando hagamos la consulta).

```sql
-- Sólo deja una reserva para cada usuario
DROP TRIGGER IF EXISTS reserva_diaria;

DELIMITER $$
CREATE TRIGGER `reserva_diaria`
  BEFORE INSERT ON `reserva` FOR EACH ROW
  BEGIN
    IF (SELECT COUNT(*) FROM `reserva` 
    WHERE `reserva`.`fecha` = NEW.`fecha` 
      AND `reserva`.`usuario`= NEW.`usuario`) > 0
    THEN
      SIGNAL sqlstate '45001'
        SET message_text = 'Sólo se permite una reserva al día.';
    END IF;
  END;
$$
```

## Ejemplo 2: No podemos reservar con más de dos semanas de antelación

Volvamos al problema inicial, el sistema de gestión de reservas. Si no controlamos un poco las fechas de las reservas, podemos encontrarnos que usuarios malintencionados pueden comprometer la integridad del sistema o situaciones indeseadas. Por tanto deberíamos controlar que:

1. No se pueda borrar o actualizar reservas pasadas:
   1. No se puede borrar reservas ya pasadas. Si se permitiera borrar reservas, podríamos borrar una ya pasada, luego podríamos librarnos de pagar las instalaciones que hemos disfrutado (disparador "ON DELETE").
   2. Al día siguiente, o al haber pasado la hora de una reserva, si ponen esa misma reserva a otro nombre, puede ocurrir que a final de mes en vez de cobrar al usuario que ha disfrutado de la instalación, se le va a cobrar a otro (disparador "ON UPDATE").
2. No se puede reservar en fechas anteriores al día actual. No tiene sentido.
3. No se permite reservar con más de dos semanas de antelación. En caso contrario, un usuario podría reservar todos los días del año a las 18:00 una instalación, por ejemplo.

Ejemplo de disparador (caso 1.1): Observa cómo no podemos usar ahora "NEW.\*" para acceder a un campo, pues no existiría al borrar, sólo podemos usar "OLD.\*" para ello:

```sql
DROP TRIGGER IF EXISTS reserva_pasado;

DELIMITER $$
CREATE TRIGGER `reserva_pasado`
  BEFORE DELETE ON `reserva` FOR EACH ROW
  BEGIN
    IF ( OLD.`fecha` < CURDATE())
    THEN
      SIGNAL sqlstate '45004'
        SET message_text = 'No se permite eliminar una fecha pasada.';
    END IF;
  END;
$$
```

En este ejemplo surge la pregunta... ¿y si borro el mismo día de la reserva?. Esto ya sería una consulta más complicada, pues habría que mirar que la hora actual es menor que la hora de inicio del horario de la reserva (habría que hacer una consulta más compleja con un JOIN). Puedes intentarlo para ampliar.

Ejemplo de disparador (caso 1.2): No se puede cambiar de nombre (a otra persona) una reserva el día de la misma o cuando ha pasado:

```sql
DROP TRIGGER IF EXISTS reserva_actualizar_pasado;

DELIMITER $$
CREATE TRIGGER `reserva_actualizar_pasado`
  BEFORE UPDATE ON `reserva` FOR EACH ROW
  BEGIN
    IF ( OLD.`fecha` <= CURDATE())
    THEN
      SIGNAL sqlstate '45004'
        SET message_text = 'No se permite actualizar una reserva ya o casi pasada.';
    END IF;
  END;
$$
```

Ejemplo de disparador (casos 2 y 3):

```sql
-- Si machacamos reservas antiguas bajo otro nombre, nos libramos de pagar a final de mes...
DROP TRIGGER IF EXISTS reserva_semanal;

DELIMITER $$
CREATE TRIGGER `reserva_semanal`
  BEFORE INSERT ON `reserva` FOR EACH ROW
  BEGIN
    IF ( NEW.`fecha` < CURDATE())
    THEN
      SIGNAL sqlstate '45002'
        SET message_text = 'No se permite reservar en una fecha anterior a la actual.';
    ELSEIF ( NEW.`fecha` > DATE_ADD(CURDATE(), INTERVAL 14 DAY) )
    THEN
        SIGNAL sqlstate '45003'
          SET message_text = 'No se permite reservar con más de dos semanas de antelación.';
    END IF;
  END;
$$
```
