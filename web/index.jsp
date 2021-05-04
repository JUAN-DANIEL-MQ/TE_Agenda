<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.emergentes.Modelo.Tarea"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList "%>
<%
     List<Tarea> lita = (List<Tarea>)request.getAttribute("lista");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Tareas!</h1>
        <p><a href="Controlador?op=nuevo"> Nueva Tarea </a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tarea</th>
                <th>Prioridad</th>
                <th>Completado</th>
                <th>Editar </th>
                <th>Eliminar</th>
            </tr>
            
            <c:forEach var="item" items="${lista}">
            <tr>
                <td> ${item.id} </td>
                <td> ${item.nombre} </td>
                <td> ${ item.prioridad } </td>
                <td> ${item.completado} </td>
                <td> <a href="Controlador?op=editar&id=${item.id}">Editar</a> </td>
                <td> <a href="Controlador?op=eliminar&id=${item.id}">Eliminar</a> </td>
            </tr>
            </c:forEach>  
        </table>
    </body>
</html>
