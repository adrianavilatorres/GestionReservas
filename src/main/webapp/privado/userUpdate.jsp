<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="userList" dataSource="jdbc/gestionReservas">
    select id, username, email, password from usuario;
</sql:query>


<%@ include file="../header.jsp" %>
<div id="paso1" align="center">
    <div class="form" id="user-form">
        <caption><h2>Seleccione el usuario que desea actualizar</h2></caption>
        <select id="userId">
            <c:forEach var="usuario" items="${userList.rows}">
                <option value="${usuario.id}"/> 
                    <c:out value="${usuario.username}" />
                    / 
                    <c:out value="${usuario.email}" />
                </option>
            </c:forEach>
        </select>
    </div>
    <button onclick="recargar()">Enviar</button>
</div>

<div id="paso2" align="center">
    <div class="form">
        ID: <input id="userid" type="text" disabled /> <br/>
        Username: <input id="username" type="text" placeholder="Nombre de usuario" /> <br/>
        Password: <input id="password" type="text" placeholder="Contraseña" /><br/>
        Email: <input id="email" type="email" placeholder="email" /><br/>
        <button onclick="enviar()">Enviar</button>
    </div>
</div>


<script type="text/javascript">
    $("#paso2").hide();
    $("#user-form > option").first().attr("selected", true);
    // $("#user-form > option").first().prop("selected", true);
    
    function recargar(){
        var $form = $("#user-form");
        var userId = $("#userId").val();
        var username = $("#userId option:selected").text();
        var url = 'http://localhost:9090/user/'+userId;
        
        console.log('Intentando borrar usuario: id='+userId+' username='+username);
        $.ajax({
            type : 'GET',
            url : url,
            contentType: 'application/json',
            // data : JSON.stringify({name: userName, email: userEmail}),
            success : function(data, status, xhr){
                console.log(data);
                let usuario = data;
                $("#paso1").hide();
                $("#paso2").show();
                $("#username").val(usuario.username);
                $("#password").val(usuario.password);
                $("#email").val(usuario.email);
                $("#userid").val(usuario.id);
                
            },
            error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
            }
        });
        $("#paso1").hide();
        $("#paso2").show();
    };
    
    
    function enviar(){
        var url = 'http://localhost:9090/user/'+$("#userid").val();
        var datos = {};
        datos.username = $("#username").val();
        datos.password = $("#password").val();
        datos.email = $("#email").val();
        datos.id = $("#userid").val();
    
        $.ajax({
            type : 'PUT',
            complete: function(data, status, xhr){
                console.log("EXITO!!!!!!");
                window.location.replace("userRead.jsp");          
            },
            url : url,
            contentType: 'application/json',
            data : JSON.stringify(datos),
            error: function(xhr, status, error){
                $('#msg').html('<span style=\'color:red;\'>'+error+'</span>');
            }
        });
    }
    </script>
        
        

<%@ include file="../footer.jsp"%> 
