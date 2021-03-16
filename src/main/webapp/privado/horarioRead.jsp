<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="horarioList" dataSource="jdbc/gestionReservas">
    select h.id, i.nombre, h.inicio, h.fin 
    from horario h, instalacion i
    where h.instalacion = i.id
    order by i.nombre, h.inicio;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de horarios</h2>
        <form>
            <div class="form-group row">
                <label for="buscadorHorario" class="col-sm-2 col-form-label col-form-label-lg">Buscar:</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control form-control-lg" id="buscadorHorario" placeholder="Introduzca el texto a buscar...">
                </div>
            </div>
        </form>
        <table class="table" id="datos">
            <thead>
                <tr>
                    <th> # </th>
                    <th>Instalación</th>
                    <th>Hora inicio</th>
                    <th>Hora fin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="horario" items="${horarioList.rows}">
                    <tr>
                        <td><c:out value="${horario.id}"/></td>
                        <td><c:out value="${horario.nombre}" /></td>
                        <td><c:out value="${horario.inicio}" /></td>
                        <td><c:out value="${horario.fin}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script>
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
    </script>
<%@ include file="../footer.jsp"%> 