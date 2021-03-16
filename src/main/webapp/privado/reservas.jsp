<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<sql:query var="reservaList" dataSource="jdbc/gestionReservas">
    select i.nombre, u.username, h.inicio, h.fin, r.fecha, r.id, r.usuario
    from reserva r, usuario u, horario h, instalacion i
    where r.usuario = u.id and r.horario = h.id and i.id = (select h.instalacion where h.id = r.horario)
    order by i.nombre
</sql:query>
<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de reservas</h2>
        <form>
            <div class="form-group row">
                <label for="buscadorHorario" class="col-sm-2 col-form-label col-form-label-lg">Buscar:</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control form-control-lg" id="buscadorHorario" placeholder="Introduzca el texto a buscar...">
                </div>
            </div>
        </form>
        <table class="table">
            <thead>
                <tr>
                    <th>Instalacion</th>
                    <th>Usuario</th>
                    <th>Horario Inicio</th>
                    <th>Horario Fin</th>
                    <th>Fecha</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="reserva" items="${reservaList.rows}">
                    <tr>
                        <td><c:out value="${reserva.nombre}"/></td>
                        <td><c:out value="${reserva.username}" /></td>
                        <td><c:out value="${reserva.inicio}" /></td>
                        <td><c:out value="${reserva.fin}" /></td>
                        <td><c:out value="${reserva.fecha}" /></td>
                        
                        <td><button class="btn btn-danger reserva_${reserva.usuario}" disabled="true"  value="${reserva.usuario}" onclick="eliminar('${reserva.id}')"> eliminar </button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        //var cname = document.cookie



            function getCookie(cname) {
            var name = cname + "=";
            var decodedCookie = decodeURIComponent(document.cookie);
            var ca = decodedCookie.split(';');
            for(var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') {
                c = c.substring(1);
                }
                if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
                }
            }
            return "";
            }


            
            window.onload = function() {
                var user=getCookie("ges_res.userId");
                var array =  document.getElementsByClassName("reserva_" + user)
                //console.log(array)
                for (let index = 0; index < array.length; index++) {
                    document.getElementsByClassName("reserva_" + user)[index].disabled=false
                }
            }
                
            



        $("#buscadorHorario").on("input",function (){
            datos=$("#buscadorHorario").val();
            // oculta todo
            $("tr").hide();
            // muestra sólo la selección: un TR que contiene TD con estos datos
            $("tr:has(td:contains("+datos+"))").each(function(){
                console.log($(this));
                $(this).show();
            });
        });



        function eliminar(id){
            var deleted =  confirm("¿Desea eliminar la reserva?")

            if (deleted) {
                var url = 'http://localhost:9090/rest/api/reservass/'+id
                console.log(id)

                $.ajax({
                    type : 'DELETE',
                    url : url,
                    contentType: 'application/json',
                    success : function(data, status, xhr){
                        window.location.replace("reservas.jsp");
                    },
                    error: function(xhr, status, error){
                        $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
                    }
                });
            }
            

        }
    </script>
<%@ include file="../footer.jsp"%> 