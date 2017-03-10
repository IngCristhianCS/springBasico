<%-- 
    Document   : exito
    Created on : 16/02/2017, 05:24:10 PM
    Author     : Cristhian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultados</h1>
        <ul>
            <li>Nombre : <c:out value="${nombre}"/></li>
            <li>Email : <c:out value="${email}"/></li>
            <li>Edad : <c:out value="${edad}"/></li>
        </ul>
    </body>
</html>
