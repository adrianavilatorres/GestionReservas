-- COMO ROOT PARA CREAR LA BBDD Y EL USUARIO

-- CREAMOS LA BBDD PARA UTF-8 COLLATION EN ESPAÑOL
CREATE DATABASE gestion_reservas CHARACTER SET utf8 COLLATE utf8_spanish_ci;

-- CAMBIAMOS LA BBDD ACTIVA
USE gestion_reservas;

-- para no tener problemas con la zona horaria (al guardar horas que aprezca una más)
SET GLOBAL time_zone = '+1:00';
-- para no tener problemas con los acentos
SET names 'utf8';

-- CREAMOS LAS TABLAS
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` varchar(12) UNIQUE NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE='InnoDB';

CREATE TABLE `instalacion` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(50) NOT NULL
) ENGINE='InnoDB';

CREATE TABLE `horario` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `instalacion` int(11) NOT NULL,
  `inicio` time NOT NULL,
  `fin` time NOT NULL,
  FOREIGN KEY (`instalacion`) REFERENCES `instalacion` (`id`) ON DELETE CASCADE
) ENGINE='InnoDB';

CREATE TABLE `reserva` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `usuario` int(11) NOT NULL,
  `horario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  FOREIGN KEY (`horario`) REFERENCES `horario` (`id`)
) ENGINE='InnoDB';


INSERT INTO `usuario` (`id`, `username`, `password`, `email`) VALUES
(2,	'pepillo',	'secreto',	'pepe@gmail.com'),
(5,	'admin',	'admin',	'admin@correo.com'),
(7,	'obijuan',	'starwars',	'darkside@starwars.com'),
(13,	'gerente',	'password1234',	'gerencia@vdc.com');

INSERT INTO `instalacion` (`id`, `nombre`) VALUES
(7,	'tenis arriba'),
(8,	'tenis césped artificial'),
(9,	'fútbol'),
(10,	'baloncesto'),
(11,	'squash'),
(13,	'sauna mujeres'),
(14,	'pista de pádel'),
(16,	'sauna caballeros');


INSERT INTO `horario` (`id`, `instalacion`, `inicio`, `fin`) VALUES
(1,	7,	'08:00:00',	'09:00:00'),
(2,	7,	'09:00:00',	'10:00:00'),
(3,	7,	'10:00:00',	'11:00:00'),
(4,	7,	'11:00:00',	'12:00:00'),
(5,	7,	'12:00:00',	'13:00:00'),
(6,	7,	'13:00:00',	'14:00:00'),
(7,	7,	'14:00:00',	'15:00:00'),
(8,	7,	'15:00:00',	'16:00:00'),
(9,	7,	'16:00:00',	'17:00:00'),
(10,	7,	'17:00:00',	'18:00:00'),
(11,	7,	'18:00:00',	'19:00:00'),
(12,	7,	'19:00:00',	'20:00:00'),
(13,	7,	'20:00:00',	'21:00:00'),
(14,	7,	'21:00:00',	'22:00:00'),
(15,	7,	'22:00:00',	'23:00:00'),
(16,	8,	'08:00:00',	'09:00:00'),
(17,	8,	'09:00:00',	'10:00:00'),
(18,	8,	'10:00:00',	'11:00:00'),
(19,	8,	'11:00:00',	'12:00:00'),
(20,	8,	'12:00:00',	'13:00:00'),
(21,	8,	'13:00:00',	'14:00:00'),
(22,	8,	'14:00:00',	'15:00:00'),
(23,	8,	'15:00:00',	'16:00:00'),
(24,	8,	'16:00:00',	'17:00:00'),
(25,	8,	'17:00:00',	'18:00:00'),
(26,	8,	'18:00:00',	'19:00:00'),
(27,	8,	'19:00:00',	'20:00:00'),
(28,	8,	'20:00:00',	'21:00:00'),
(29,	8,	'21:00:00',	'22:00:00'),
(30,	8,	'22:00:00',	'23:00:00'),
(31,	9,	'08:00:00',	'09:30:00'),
(32,	9,	'09:30:00',	'11:00:00'),
(33,	9,	'11:00:00',	'12:30:00'),
(34,	9,	'12:30:00',	'14:00:00'),
(35,	9,	'14:00:00',	'15:30:00'),
(36,	9,	'15:30:00',	'17:00:00'),
(37,	9,	'17:00:00',	'18:30:00'),
(38,	9,	'18:30:00',	'20:00:00'),
(39,	9,	'20:00:00',	'21:30:00'),
(40,	9,	'21:30:00',	'23:00:00'),
(41,	9,	'23:00:00',	'00:30:00'),
(42,	10,	'08:00:00',	'09:00:00'),
(43,	10,	'09:00:00',	'10:00:00'),
(44,	10,	'10:00:00',	'11:00:00'),
(45,	10,	'11:00:00',	'12:00:00'),
(46,	10,	'12:00:00',	'13:00:00'),
(47,	10,	'13:00:00',	'14:00:00'),
(48,	10,	'14:00:00',	'15:00:00'),
(49,	10,	'15:00:00',	'16:00:00'),
(50,	10,	'16:00:00',	'17:00:00'),
(51,	10,	'17:00:00',	'18:00:00'),
(52,	10,	'18:00:00',	'19:00:00'),
(53,	10,	'19:00:00',	'20:00:00'),
(54,	10,	'20:00:00',	'21:00:00'),
(55,	10,	'21:00:00',	'22:00:00'),
(56,	10,	'22:00:00',	'23:00:00'),
(57,	11,	'08:00:00',	'08:45:00'),
(58,	11,	'08:45:00',	'09:30:00'),
(59,	11,	'09:30:00',	'10:15:00'),
(60,	11,	'10:15:00',	'11:00:00'),
(61,	11,	'11:00:00',	'11:45:00'),
(62,	11,	'11:45:00',	'12:30:00'),
(63,	11,	'12:30:00',	'13:15:00'),
(64,	11,	'13:15:00',	'14:00:00'),
(65,	11,	'14:00:00',	'14:45:00'),
(66,	11,	'14:45:00',	'15:30:00'),
(67,	11,	'15:30:00',	'16:15:00'),
(68,	11,	'16:15:00',	'17:00:00'),
(69,	11,	'17:00:00',	'17:45:00'),
(70,	11,	'17:45:00',	'18:30:00'),
(71,	11,	'18:30:00',	'19:15:00'),
(72,	11,	'19:15:00',	'20:00:00'),
(73,	11,	'20:00:00',	'20:45:00'),
(74,	11,	'20:45:00',	'21:30:00'),
(75,	11,	'21:30:00',	'22:15:00'),
(103,	13,	'09:00:00',	'09:30:00'),
(104,	13,	'09:30:00',	'10:00:00'),
(105,	13,	'10:00:00',	'10:30:00'),
(106,	13,	'10:30:00',	'11:00:00'),
(107,	13,	'11:00:00',	'11:30:00'),
(108,	13,	'11:30:00',	'12:00:00'),
(109,	13,	'12:00:00',	'12:30:00'),
(110,	13,	'12:30:00',	'13:00:00'),
(111,	13,	'13:00:00',	'13:30:00'),
(112,	13,	'13:30:00',	'14:00:00'),
(113,	13,	'14:00:00',	'14:30:00'),
(114,	13,	'14:30:00',	'15:00:00'),
(115,	13,	'15:00:00',	'15:30:00'),
(116,	13,	'15:30:00',	'16:00:00'),
(117,	13,	'16:00:00',	'16:30:00'),
(118,	13,	'16:30:00',	'17:00:00'),
(119,	13,	'17:00:00',	'17:30:00'),
(120,	13,	'17:30:00',	'18:00:00'),
(121,	13,	'18:00:00',	'18:30:00'),
(122,	13,	'18:30:00',	'19:00:00'),
(123,	13,	'19:00:00',	'19:30:00'),
(124,	13,	'19:30:00',	'20:00:00'),
(125,	13,	'20:00:00',	'20:30:00'),
(126,	13,	'20:30:00',	'21:00:00'),
(127,	13,	'21:00:00',	'21:30:00'),
(128,	13,	'21:30:00',	'22:00:00'),
(129,	13,	'22:00:00',	'22:30:00'),
(130,	14,	'08:00:00',	'09:30:00'),
(131,	14,	'09:30:00',	'11:00:00'),
(132,	14,	'11:00:00',	'12:30:00'),
(133,	14,	'12:30:00',	'14:00:00'),
(134,	14,	'14:00:00',	'15:30:00'),
(135,	14,	'15:30:00',	'17:00:00'),
(136,	14,	'17:00:00',	'18:30:00'),
(137,	14,	'18:30:00',	'20:00:00'),
(138,	14,	'20:00:00',	'21:30:00'),
(139,	14,	'21:30:00',	'23:00:00'),
(140,	14,	'23:00:00',	'00:30:00');

INSERT INTO `reserva` (`id`, `usuario`, `horario`, `fecha`) VALUES
(1,	2,	130,	'2019-10-12'),
(2,	2,	130,	'2019-10-13'),
(4,	7,	120,	'2019-11-11'),
(5,	7,	130,	'2019-11-21');


DROP TRIGGER IF EXISTS reserva_pasado;

CREATE TRIGGER `reserva_pasado`
  BEFORE DELETE ON `reserva` FOR EACH ROW
  BEGIN
    IF ( OLD.`fecha` < CURDATE())
    THEN
      SIGNAL sqlstate '45004'
        SET message_text = 'No se permite eliminar una fecha pasada.';
    END IF;
  END;


DROP TRIGGER IF EXISTS reserva_actualizar_pasado;

CREATE TRIGGER `reserva_actualizar_pasado`
  BEFORE UPDATE ON `reserva` FOR EACH ROW
  BEGIN
    IF ( OLD.`fecha` <= CURDATE())
    THEN
      SIGNAL sqlstate '45004'
        SET message_text = 'No se permite actualizar una reserva ya pasada o en el día de la misma.';
    END IF;
  END;




DROP TRIGGER IF EXISTS reserva_semanal;

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

