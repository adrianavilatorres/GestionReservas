<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<sql:query var="instalacionList" dataSource="jdbc/gestionReservas">
    select * from instalacion
</sql:query>

<%@ include file="../header.jsp" %>
    <div class="card">
        <form action="/horario" method="POST">
            <div class="form-group">
                <label for="instalacion">Seleccione la Instalación</label>
                <select class="form-control" name="instalacion" id="instalacion">
                    <c:forEach var="instalacion" items="${instalacionList.rows}">
                        <option value="${instalacion.id}">
                            <c:out value="${instalacion.nombre}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="horaInicio">Hora de Inicio</label>
                <input name="inicio" type="time" id="horaInicio" />
            </div>
            <div class="form-group">

                <label for="horaFin">Hora de Fin</label>
                <input name="fin" type="time" id="horaFin" />
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="submit">Enviar</button>
            </div>
        </form>
    </div>
<%@ include file="../footer.jsp"%> 
