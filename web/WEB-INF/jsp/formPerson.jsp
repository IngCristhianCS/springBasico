<%-- 
    Document   : formPerson
    Created on : 16/02/2017, 04:41:50 PM
    Author     : Cristhian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="${pageContext.request.contextPath}/public/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
        <script src="${pageContext.request.contextPath}/public/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/bootstrap/js/bootstrap.min.js"></script>


    </head>
    <body>
        <div class="container">
            <h1>Hola</h1>
            <form:form commandName="person">                
                <form:label path="nombre">Nombre</form:label>
                <form:input path="nombre" class="form-control"></form:input>
                <form:errors path="nombre" element="div" cssClass="alert alert-danger"></form:errors>
                <form:label path="edad">Edad</form:label>
                <form:input path="edad" class="form-control"></form:input>
                <form:errors path="edad" element="div" cssClass="alert alert-danger"></form:errors>
                <form:label path="email">Email</form:label>
                <form:input path="email" class="form-control"></form:input>
                <form:errors path="email" element="div" cssClass="alert alert-danger"></form:errors>
                <form:label path="pais">Pais</form:label>
                <form:select path="pais" class="form-control">
                    <form:option value="0">Selecciona .....</form:option>
                    <form:options items="${paisLista}"></form:options>
                </form:select>
                <form:errors path="pais" element="div" cssClass="alert alert-danger alert-dismissible"></form:errors>
                <hr>
                <form:button class="btn btn-primary">Enviar</form:button>
            </form:form>
        </div>
    </body>
</html>