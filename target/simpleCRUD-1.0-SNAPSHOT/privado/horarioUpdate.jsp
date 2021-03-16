<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="installationList" dataSource="jdbc/gestionReservas">
    select id, nombre from instalacion;
</sql:query>


<%@ include file="../header.jsp" %>

    <div id="paso1" align="center">
        <div class="form" id="user-form">
            <caption><h2>Seleccione la instalación del horario que desea actualizar o borrar</h2></caption>
            <select id="installationIdSelect" onchange="mostrarHorarios()">
                <c:forEach var="installation" items="${installationList.rows}">
                    <option value="${installation.id}"/> 
                        <c:out value="${installation.nombre}" />
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div id="paso2" align="center">
        Selección de horario
    </div>

    <div id="paso3" align="center">
        <form>
            <div class="form-group">
                <label for="instalacion">Horario:</label>
                <input disabled class="form-control" name="horario" id="horarioID" />
            </div>
            <div class="form-group">
                <label for="instalacion">Instalación:</label>
                <input disabled class="form-control" name="instalacionID" id="instalacionID" />
                <input disabled class="form-control" name="instalacion" id="instalacion" />
            </div>
            <div class="form-group">
                <label for="horaInicio">Hora de Inicio</label>
                <input name="inicio" type="time" id="horaInicio" val="12:00" />
            </div>
            <div class="form-group">
                <label for="horaFin">Hora de Fin</label>
                <input name="fin" type="time" id="horaFin" val="12:00" />
            </div>
            <div class="form-group">
                <div id="btnModificar" class="btn btn-primary" type="submit" onclick="modificar()">Modificar</div>
                <div id="btnBorrar" class="btn btn-danger" type="submit" onclick="eliminar()">Eliminar</div>
            </div>
        </form>
    </div>

<script type="text/javascript">
 
$("#paso2").hide();
$("#paso3").hide();

$("#user-form > option").first().attr("selected", true);
// $("#user-form > option").first().prop("selected", true);

function mostrarHorarios(){
    // $("#paso1").hide();
    // pedimos al backend los horarios de una instalación dada
    let instalacionID = $("#installationIdSelect").val();
    let url = 'http://localhost:9090/rest/api/horario/instalacion/'+instalacionID;
    // 
    $.ajax({
            type : 'GET',
            url : url,
            contentType: 'application/json',
            // data : JSON.stringify({name: userName, email: userEmail}),
            success : function(data, status, xhr){
                console.log(data);
                let horarios = data;
                var html = '<table class="table">';
                html += '<thead><tr><th>instalacion</th><th>inicio</th><th>fin</th><th>acción</th></tr></thead>';
                html += '<tbody>';   
                horarios.forEach( (horario) =>{
                    /*
                    let inicio = new Date();
                    inicio.setHours(horario.inicio.hour);
                    inicio.setMinutes(horario.inicio.minute);
                    inicio.setSeconds(0);

                    let fin = new Date();
                    fin.setHours(horario.fin.hour);
                    fin.setMinutes(horario.fin.minute);
                    fin.setSeconds(0);
                    */
                    html += '<tr>';
                    html += '<td>'+horario.instalacion.name+'</td>';
                    html += '<td>'+horario.inicio+'</td>';
                    html += '<td>'+horario.fin+'</td>';
                    html += '<td>'+ 
                        '<button class="btn btn-info" onclick="formularioM('+horario.id+', 1)"> modificar </button>' + 
                        '<button class="btn btn-danger" onclick="formularioM('+horario.id+', 2)"> eliminar </button>' + 
                        '<button class="btn btn-success" onclick="formularioR('+horario.id+')"> reservar </button>' + 
                        '</td>';
                    html += '</tr>';
                });
                html += '</tbody>';
                html += '</table>';
                $('#paso2').html(html);
                $('#paso2').show();
            },
            error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
            }
        });

};

function setTimeOnInput(id, time) {
  $(id).attr({'value': time});
};


function formularioM(id, opcion) {
    $("#paso2").hide();
    $("#paso3").show();
    if (opcion==2) { // borrar
        $("#btnModificar").hide();
        $("#btnBorrar").show();
    } else { // modificar
        $("#btnModificar").show();
        $("#btnBorrar").hide();
    }
    let url = 'http://localhost:9090/rest/api/horario/'+id;
    // 
    $.ajax({
            type : 'GET',
            url : url,
            contentType: 'application/json',
            // data : JSON.stringify({name: userName, email: userEmail}),
            success : function(data, status, xhr){
                let horario = data;
                $("#horarioID").val(horario.id);
                $("#instalacionID").val(horario.instalacion.id);
                $("#instalacion").val(horario.instalacion.name);
                setTimeOnInput("#horaInicio",horario.inicio);
                setTimeOnInput("#horaFin",horario.fin);
            },
            error: function(xhr, status, error){
                $('#msg').html('<span style=\'color:red;\'>'+error+'</span>');
            }
        });
}


function modificar(id){
    var url = 'http://localhost:9090/rest/api/horario/'+$("#horarioID").val();
    var datos = {};
    datos.id = $("#horarioID").val();
    datos.instalacion = {};
    datos.instalacion.id = $("#instalacionID").val();
    datos.instalacion.name = $("#instalacion").val();
    /* $("#horaInicio").val().split(":");
    datos.inicio = {
        hour: hour,
        minute: minute
    };*/
    datos.inicio = $("#horaInicio").val();
    /*[hour, minute] = $("#horaFin").val().split(":");
    datos.fin = {
        hour: hour,
        minute: minute
    }*/
    datos.fin = $("#horaFin").val();
    console.log(datos);
    $.ajax({
        type : 'PUT',
        url : url,
        contentType: 'application/json',
        dataType: 'json',
        data : JSON.stringify(datos),
        success : function(data, status, xhr){
            window.location.replace("horarioRead.jsp");
        },
        error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>');
        }
    });
}


function eliminar(){
    
    var horarioId = $("#horarioID").val();
    var url = 'http://localhost:9090/horario/'+horarioId;

    $.ajax({
        type : 'DELETE',
        url : url,
        contentType: 'application/json',
        // data : JSON.stringify({name: userName, email: userEmail}),
        success : function(data, status, xhr){
            window.location.replace("horarioRead.jsp");
        },
        error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
        }
    });
};

function formularioR(id){

}
</script>


<%@ include file="../footer.jsp"%> 
