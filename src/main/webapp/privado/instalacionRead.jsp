<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="instalacionList" dataSource="jdbc/gestionReservas">
    select * from instalacion;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de instalaciones</h2>
        <table class="table">
            <thead>
                <tr>
                    <th> # </th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="instalacion" items="${instalacionList.rows}">
                    <tr>
                        <td><c:out value="${instalacion.id}"/></td>
                        <td><c:out value="${instalacion.nombre}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
<%@ include file="../footer.jsp"%> 
