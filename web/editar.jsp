<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.Modelo.Tarea"%>
<%
    Tarea tarea = (Tarea)request.getAttribute("tarea");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (tarea.getId() == 0) {%> 
        <h1>Este es un Registro de Tarea Nuevo </h1>
        <% } %>
        <% if (tarea.getId() != 0) {%> 
        <h1>Modifique los valores </h1>
        <% } %>
        <form action="Controlador?id=<%= tarea.getId() %>" method="POST">
           <input type="hidden" name="id" value="<%= tarea.getId() %>" />
            <div>
              <label>Id    </label>
              <input type="number" name="id" value= "<%= tarea.getId()%>" readonly />
            </div>  
            <br>
            <div>
              <label>Tarea</label>
              <input type="text" name="nombre" value= "<%= tarea.getNombre()%>" />
            </div> 
            <br>
            <% if (tarea.getPrioridad() == 0) {%> 
            <div>
                <label>Seleccione el nivel de Prioridad</label><br>
                 <label><input type="radio" name="prioridad" value= "1"/>Baja</label><br>
                 <label><input type="radio" name="prioridad" value= "2"/>Media</label><br>
                 <label><input type="radio" name="prioridad" value= "3"/>Alta</label><br>
            </div>
            <% } %>
            <% if (tarea.getPrioridad() == 1) {%> 
            <div>
                <label>Seleccione el nivel de Prioridad</label><br>
                <label><input type="radio" name="prioridad" value= "1" checked />Baja</label><br>
                 <label><input type="radio" name="prioridad" value= "2"/>Media</label><br>
                 <label><input type="radio" name="prioridad" value= "3"/>Alta</label><br>
            </div>
            <% } %>
            <% if (tarea.getPrioridad() == 2) {%> 
            <div>
                <label>Seleccione el nivel de Prioridad</label><br>
                <label><input type="radio" name="prioridad" value= "1"/>Baja</label><br>
                 <label><input type="radio" name="prioridad" value= "2" checked />Media</label><br>
                 <label><input type="radio" name="prioridad" value= "3"/>Alta</label><br>
            </div>
            <% } %>
            <% if (tarea.getPrioridad() == 3) {%> 
            <div>
                <label>Seleccione el nivel de Prioridad</label><br>
                <label><input type="radio" name="prioridad" value= "1"/>Baja</label><br>
                 <label><input type="radio" name="prioridad" value= "2"/>Media</label><br>
                 <label><input type="radio" name="prioridad" value= "3" checked/>Alta</label><br>
            </div>
            <% } %>
            <% if (tarea.getCompletado() == 0) {%> 
            <div>
                <label>¿La Tarea fue Completada?</label><br>
                 <label><input type="radio" name="completado" value= "1"/>Conluido</label><br>
                 <label><input type="radio" name="completado" value= "2"/>Pendiente</label><br>
            </div>
            <% } %>
            <% if (tarea.getCompletado() == 1) {%> 
            <div>
                <label>¿La Tarea fue Completada?</label><br>
                 <label><input type="radio" name="completado" value= "1" checked/>Concluido</label><br>
                 <label><input type="radio" name="completado" value= "2"/>Pendiente</label><br>
            </div>
            <% } %>
            <% if (tarea.getCompletado() == 2) {%> 
            <div>
                <label>¿La Tarea fue Completada?</label><br>
                 <label><input type="radio" name="completado" value= "1"/>Concluido</label><br>
                 <label><input type="radio" name="completado" value= "2" checked/>Pendiente</label><br>
            </div>
            <% } %>
            <input type="submit" value="Guardar"/>
        </form>
        
        
        
    </body>
</html>
