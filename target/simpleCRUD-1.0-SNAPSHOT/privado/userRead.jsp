<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="userList" dataSource="jdbc/gestionReservas">
    select * from usuario;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de usuarios</h2>
        <table class="table" >            
            <thead>
            <tr>
                <th>#</th>
                <th>username</th>
                <th>email</th>
                <th>password</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${userList.rows}">
                <tr>
                    <td><c:out value="${usuario.id}" /></td>
                    <td><c:out value="${usuario.username}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><c:out value="${usuario.password}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%@ include file="../footer.jsp"%> 
