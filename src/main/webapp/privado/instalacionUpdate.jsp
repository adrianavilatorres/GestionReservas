<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="installationList" dataSource="jdbc/gestionReservas">
    select id, nombre from instalacion;
</sql:query>


<%@ include file="../header.jsp" %>
    <div id="paso1" align="center">
        <div class="form" id="user-form">
            <caption><h2>Seleccione la instalación que desea actualizar</h2></caption>
            <select id="installationIdSelect">
                <c:forEach var="installation" items="${installationList.rows}">
                    <option value="${installation.id}"/> 
                        <c:out value="${installation.nombre}" />
                    </option>
                </c:forEach>
            </select>
        </div>
        <button class="btn btn-primary" onclick="recargar()">Enviar</button>
    </div>

    <div id="paso2" align="center">
        <div class="form">
            ID: <input id="installationID" type="text" disabled /> <br/>
            Nombre: <input id="nameInstallation" type="text" placeholder="Nombre de la instalación" /> <br/>
            <button onclick="enviar()">Enviar</button>
        </div>
    </div>

<script type="text/javascript">
 
$("#paso2").hide();

$("#user-form > option").first().attr("selected", true);
// $("#user-form > option").first().prop("selected", true);

function recargar(){
    let instalacionID = $("#installationIdSelect").val();
    let instalacionNombre = $("#installationIdSelect option:selected").text().trim();
    
    $("#paso1").hide();
    $("#paso2").show();
    $("#nameInstallation").val( instalacionNombre );
    $("#installationID").val( instalacionID );
        
};


function enviar(){
    var url = 'http://localhost:9090/installation/'+$("#installationID").val();
    var datos = {};
    datos.name = $("#nameInstallation").val();
    datos.id = $("#installationID").val();

    $.ajax({
        type : 'PUT',
        url : url,
        contentType: 'application/json',
        data : JSON.stringify(datos),
        success : function(data, status, xhr){
            window.location.replace("instalacionRead.jsp");
        },
        error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>');
        }
    });
}
</script>


<%@ include file="../footer.jsp"%> 
