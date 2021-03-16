
/**
 * Este Objeto es usado para controlar el panel activo en cada momento
 * y es llamado desde los otros objetos.
 */

// El controlador es un objeto
$.controller = {};

// propiedades del controlador (atributos)
// cuidado con el host, cámbialo a 127.0.0.1 ó localhost 
$.controller.host="backend.iesvdc.com";
$.controller.port="8080";
$.controller.api="rest/api";

$.controller.url= "http://"+$.controller.host+":"+$.controller.port+
    "/"+$.controller.api+"/";

$.controller.username="";
$.controller.password="";
$.controller.active_panel = "";

/**
 * Esta función gestiona qué panel está activo en cada momento (sólo puede
 * haber uno)
 * @param {type} panel_name el nombre del panel a activar
 */
$.controller.activate = function (panel_name) {
    $($.controller.active_panel).hide();
    $(panel_name).show();
    $.controller.active_panel = panel_name;
};

/**
 * Función para recoger los datos del Login
 */
$.controller.login = function () {
    $.controller.username = $("#username").val();
    $.controller.password = $("#password").val();
    $.controller.activate("#panel_main");
};

/**
 * Función para gestionar el panel de mensajes de error.
 * @param {type} title título del error
 * @param {type} msg mensaje del error (descripción)
 */
$.controller.error = function (title, msg) {
    var caja_error = $("#panel_error");
    caja_error.empty();
    caja_error.append('<h3>' + title + '</h3>');
    caja_error.append('<p>' + msg + '</p>');
    // cargamos el panel error
    $.controller.activate("#panel_error");
};

/**
 * Función para gestionar los códigos de retorno (error) del servidor
 * tras hacer las peticiones REST
 * @param {type} codigo
 */
$.controller.errorManager = function (codigo) {
    switch (codigo) {
        case 500: // error interno
            $.controller.error("Error 500", "No se ha podido completar la operación en el servidor");
            break;
        case 401: // no autorizado
            $.controller.activate("#panel_login");
            break;
        case 404: // no autorizado
            $.controller.error("Error 404", "No se ha encontrado el objeto");
            break;
        case 204: // sin respuesta (ej. tras un delete o un put
            $.controller.activate("#panel_main");
            break;
        default:
            $.controller.error("Error de conexión", "En estos momentos no ha sido posible acceder al servidor");
    }
}; 

/**
 * Función para gestionar la autorización contra el servidor.
 * Puedes cambiarla para hacerlo con sesiones, sessionStorage, token, OAuth...
 * @param {type} xhr las cabeceras
 */
$.controller.authorize = function(xhr) {
    // Descomentar para mandar autorización básica en las peticiones
    //xhr.setRequestHeader ("Authorization", "Basic " +  
    //    btoa($.controller.username+":"+$.controller.password));
};

/**
 * Función para crear todos los "onClick" de los menús y
 * asociarlos con cada panel correspondiente.
 */
$.controller.init = function (panel_inicial) {

    $('[id^="menu_"]').each(function () {
        var $this = $(this);
        var menu_id = $this.attr('id');
        var panel_id = menu_id.replace('menu_', 'panel_');

        $("#" + menu_id).click(function () {
            $.controller.activate("#" + panel_id);
        });
        console.log("id_menu::" + menu_id + "  id_panel" + panel_id);
    });
    $(".panel").hide();
    $(panel_inicial).show();
    $.controller.active_panel = panel_inicial;

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
                fila.append("<td>"+"<span class=\"btn btn-success\">ACTUALIZAR</span> "+"</td>");
                fila.append("<td><span class=\"btn btn-danger\">BORRAR</span> </td>");
                tabla.append(fila);
            });
            $("#panel_inst_read").append(tabla);
        });
    });

    $("#menu_inst_delete").click(()=>{
        $.controller.doGet($.controller.url+"instalacion",(datos)=>{
            $("#select_inst_delete").empty();
            console.log("preparando delete");
            datos.forEach(instalacion => {
                $("#select_inst_delete").append('<option value="'+
                    instalacion.id+'">'+
                    instalacion.name+
                    "</option>");
            });
        });
    });

    $("#menu_inst_update").click(()=>{
        $.controller.doGet($.controller.url+"instalacion",(datos)=>{
            $("#select_inst_update").empty();
            console.log("preparando delete");
            datos.forEach(instalacion => {
                $("#select_inst_update").append('<option value="'+
                    instalacion.id+'">'+
                    instalacion.name+
                    "</option>");
            });
        });
    });

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


/**
 * Función para hacer el GET al servicio REST
 * @param {type} target la URL donde está el servicio REST
 * @param {type} fn_exito función a llamar cuando tenga éxito 
 */
$.controller.doGet = function (target, fn_exito) {
    $.get({
        url: target,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        crossDomain: true,
        success: fn_exito,
        beforeSend: function (xhr) {
            $.controller.authorize(xhr);
        },
        error: function (xhr, status) {
            console.log("ERROOOOOR!!!!", xhr.status);
            $.controller.errorManager(xhr.status);                
        }});
};

/**
 * Función para hacer el POST al servicio REST
 * @param {type} target la URL donde está el servicio REST
 * @param {type} datos los datos a subir
 * @param {type} fn_exito función a llamar cuando tenga éxito 
 */
$.controller.doPost = function(target, datos, fn_exito) {
    $.ajax({
            url: $.alumno.HOST + $.alumno.URL,
            method: 'POST',
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(datos),
            /*beforeSend: function (xhr) {
                $.controller.authorize(xhr);
            },*/
            success: fn_exito,
            error: function (xhr, status) {
                $.controller.errorManager(xhr.status);                
            }
        });
};

/**
 * 
 * @param {type} target
 * @param {type} id
 * @param {type} datos
 * @param {type} fn_exito
 */
$.controller.doPut = function(target, id, datos, fn_exito) {
    $.ajax({
        url: target+'/'+id,
        method: 'PUT',
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(datos),
        /*beforeSend: function (xhr) {
            $.controller.authorize(xhr);
        },*/
        success: fn_exito,
        error: function (xhr, status) {
            $.controller.errorManager(xhr.status);                
        }
    });
};

/**
 * 
 * @param {type} target
 * @param {type} id
 * @param {type} fn_exito
 */
$.controller.doDelete = function(target, id, fn_exito) {
    $.ajax({
        url: target + '/' + id,
        method: 'DELETE',
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        /*beforeSend: function (xhr) {
            $.controller.authorize(xhr);
        },*/
        // data: JSON.stringify(datos),
        success: fn_exito,
        error: function (xhr, status) {
            $.controller.errorManager(xhr.status);                
        }
    });
};
