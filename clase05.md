# Aplicación híbrida 

Recordamos que se trata de tener una aplicación HTML5+JS donde existen varias cajas ocultas que contienen las diferentes vistas de la aplicación. En cada momento vamos cambiando de una a otra según un menú principal que hace de controlador para activar/desactivar vistas.

La aplicación se comunica con el servicio REST con verbos HTTP (ej. GET/POST/PUT/DELETE).

Ya tenemos implementados los siguientes *end-points* en el **back-end**:


|	Descripción 							| Verbo HTTP 	| ruta						| 
|---										|--- 			|--- 						|
| Listar todas las instalaciones			| GET			| /api/instalacion		    |
| Ver el detalle de una instalación			| GET			| /api/instalacion/{id}	|
| Crear una nueva instalación				| POST			| /api/instalacion			|
| Borrar una instalación					| DELETE		| /api/instalacion/{id}	|
| Buscar una instalación por nombre  	    | GET			| /api/instalacion/nombre/{nombre}			|

Ahora vamos a preparar una APP híbrida como **front-end**, que con AJAX haga esas consultas y muestre los resultados.

## Modificando el backend para que soporte peticiones de otro origen

Para resolver el [problema del CORS](https://developer.mozilla.org/es/docs/Web/HTTP/Access_control_CORS) deberemos crear un filtro que intercepte peticiones de origen cruzado y las permita sólo para los servicios visibles a nuestra aplicación.

Ejemplo de filtro CORS Java:

```java
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
    
    public class CORSFilter implements Filter {

        public void doFilter( 
          ServletRequest req, 
          ServletResponse res, 
          FilterChain chain) throws IOException, ServletException {
         
         HttpServletResponse response = (HttpServletResponse) res;
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
         response.setHeader("Access-Control-Max-Age", "3600");
         response.setHeader("Access-Control-Allow-Headers", 
          "Origin, x-requested-with, Content-Type, Accept");
         chain.doFilter(req, res);
        }
       
        public void init(FilterConfig filterConfig) {}
       
        public void destroy() {}

}
```

Recuerda modificar el fichero **web.xml** para que la ruta del Web Service tenga permitido el acceso desde orígenes desconocidos:

```xml
  <filter>
        <filter-name>CorsFilter</filter-name>
        <filter-class>com.iesvdc.acceso.simplecrud.controller.CORSFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>CorsFilter</filter-name>
        <url-pattern>/rest/*</url-pattern>
    </filter-mapping>
```

## Preparación del entorno

Creamos una carpeta frontend en nuestro proyecto Web. Para crear el proyecto Cordova, ejecutamos los siguientes comandos en la terminal dentro del directorio recién creado:

```console
$ npm install -g cordova
$ cordova create reservas com.iesvdc.dam.acceso ReservAPP
$ cd reservas
$ cordova platform add browser
$ npm install jquery
$ npm install popper.js
$ npm install bootstrap
```

Ahora, de los directorios node_modules que se han creado para cada una de las instalaciones. Me creo un script añadir dependencias:

```bash
#!/bin/bash

mkdir -p www/vendor/js www/vendor/css
echo "Añadiendo jQuery"
cp node_modules/jquery/dist/jquery.min.js \
  node_modules/jquery/dist/jquery.min.map www/vendor/js
echo "Añadiendo PopperJS"
cp node_modules/popper.js/dist/popper.min.js \
  node_modules/popper.js/dist/popper.min.js.map www/vendor/js
echo "Añadiendo Bootstrap"
cp node_modules/bootstrap/dist/css/bootstrap.min.css www/vendor/css
cp node_modules/bootstrap/dist/js/bootstrap.min.js \
  node_modules/bootstrap/dist/js/bootstrap.min.js.map www/vendor/js
```

Para lanzar un navegador Web Cordova:

```bash
cordova run browser
```

## Ejemplo de aplicación HTML5/JS

En la carpeta **www** recién creada por *cordova*, vamos a editar el fichero index.html. La idea es hacer  una [SAP (Single Application Page)](https://es.wikipedia.org/wiki/Single-page_application), luego vamos a crear una serie de vistas, que llamaremos "paneles", que serán cajas ocultas (etiqueta div). Con un menú vamos mostrando una u otra vista (panel) según donde vamos pulsando.

Ejemplo de paneles [(fichero index.html)](frontend/reservas/www/index.html):

```html
    <div class="row">
      <div class="panel" id="panel_inicio">
        <h2>Modelo servicio REST</h2>
      </div>
      <div class="panel" id="panel_inst_read">
        <h2>Listado de instalaciones</h2>
        <div id="panel_inst_list" class="input-group mb-3">
            Aquí va el listado.
        </div>
      </div>
      <div class="panel" id="panel_inst_update">
        <h2>Actualización de una instalación</h2>
        <div class="input-group mb-3">
          <select class="custom-select" id="select_inst_update">
            <option>instalacion</option>
          </select>
          <button id="btn_inst_update" type="button" class="btn btn-primary">
            actualizar</button>
        </div>
      </div>
      <div class="panel" id="panel_inst_delete">
        <h2>Borrado de instalaciones</h2>
        <div class="input-group mb-3">
          <select class="custom-select" id="select_inst_delete">
            <option>instalacion</option>
          </select>
          <button id="btn_inst_delete" type="button" class="btn btn-danger">borrar</button>
        </div>
      </div>
      <div class="panel" id="panel_inst_create">
        <h2>Alta de instalacion</h2>
        <div class="input-group mb-3">
          <input type="text" class="form-control" id="nombre_inst_create" />
          <button id="btn_inst_create" type="button" class="btn btn-success">crear</button>
        </div>
      </div>
    </div>
```

Ahora con JavaScript (y jQuery) es muy fácil ocultar todos los DIV de la clase PANEL y mostrar únicamente la vista o panel que nos interese en cada momento. Bastaría con hacer un:

```javascript
  $(".panel").hide();
  $("#id_panel_a_mostrar").show();
```

Fíjate bien en los ID que hemos dado a cada panel y ahora veamos el menú de la WebApp, observa también los ID de cada menú del CRUD:

```html
    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
      <a id="menu_inst_read" class="dropdown-item" href="#">Listado</a>
      <a id="menu_inst_create" class="dropdown-item" href="#">Alta</a>
      <a id="menu_inst_update" class="dropdown-item" href="#">Actualización</a>
      <a id="menu_inst_delete" class="dropdown-item" href="#">Baja</a>
    </div>
```

¿Has visto cómo cada menu_inst_* tiene su panel panel_inst_* ? Esto lo hemos hecho así para ahora con JavaScript conectar el evento de pulsar en un menú con su panel correspondiente [(fichero www/js/controller.js)](frontend/reservas/www/js/controller.js):

```javascript

$.controller.active_panel = "#panel_inicio";

$.controller.activate = function (panel_name) {
    $($.controller.active_panel).hide();
    $(panel_name).show();
    $.controller.active_panel = panel_name;
};

$.controller.init = function (panel_inicial) {
    $('[id^="menu_"]').each(function () {
        var $this = $(this);
        var menu_id = $this.attr('id');
        var panel_id = menu_id.replace('menu_', 'panel_');

        $("#" + menu_id).click(function () {
            $.controller.activate("#" + panel_id);
        });
    });
```

Ahora falta darle funcionalidad a cada botón del controlador para terminar el CRUD del servicio. Además de completar el código de cada evento "on click" [(fichero www/js/controller.js)](frontend/reservas/www/js/controller.js), posiblemente tengamos que añadir algún panel más al [fichero index.html](frontend/reservas/www/index.html):

```javascript
    $.controller.init = function (panel_inicial) {

    ....

    $("#btn_inst_create").click(()=>{
        console.log("btn_inst_create-onClick::TODO:: falta llamar al doPost");
    });

    $("#btn_inst_update").click(()=>{
        console.log("btn_inst_update-onClick::TODO:: falta llamar al doGet "+
            "para poblar el formulario y luego hacer el doPut");
    });

    $("#btn_inst_delete").click(()=>{
        console.log("btn_inst_delete-onClick::TODO:: falta llamar al doDelete");
    });

};
```

Ya está hecho el **READ** del **CRUD de instalación** para ayudarte en la tarea, fíjate cómo se hace el "binding" de evento "pulsar sobre el menú read" y generar una tabla a partir del JSON que pedimos al Webservice.

```javascript
    $("#menu_inst_read").click(()=>{
        console.log("listando instalaciones... ");
        $.controller.doGet($.controller.url+"instalacion", function(datos){
            console.log("listando instalaciones: "+datos);
            $("#panel_inst_read").empty();
            let tabla=$("<table/>");
            datos.forEach(instalacion => {
                let fila=$("<tr/>");
                fila.append("<td>"+"Instalación "+instalacion.id+"</td>");
                fila.append("<td>"+instalacion.name+"</td>");
                fila.append("<td>"+
                  "<span class=\"btn btn-success\">ACTUALIZAR</span> "+
                  "</td>");
                fila.append("<td><span class=\"btn btn-danger\">BORRAR</span> </td>");
                tabla.append(fila);
            });
            $("#panel_inst_read").append(tabla);
        });
    });
```

## Localtunel

Para probar el servicio en Internet:

npm install -g localtunnel

lt --port 9090