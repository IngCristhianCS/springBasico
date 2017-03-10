
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="${pageContext.request.contextPath}/public/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/public/alertify/css/alertify.min.css" rel="stylesheet" />        
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">        
        <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
        <script src="${pageContext.request.contextPath}/public/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/alertify/js/alertify.min.js"></script>
        <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>        
        <script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.1.1/js/responsive.bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/public/js/functions.min.js"></script>

    </head>
    <body>
        <div class="container container-fluid">
            <h1>Hola</h1>
            <div class="row">
                <div class="col-lg-10 col-md-10 col-lg-offset-1 col-md-offset-1 col-sm-12 col-xs-12">
                     <div class="panel panel-info">
                        <div class="panel-heading">
                            <a 
                                href="${pageContext.request.contextPath}/formPerson.htm" 
                                class="btn btn-success">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar
                            </a>
                        </div>
                        <div class="panel-body">
                            <table class="table table-responsive" cellspacing="0" width="100%" id="usuarios"> 
                                <thead> 
                                    <tr> 
                                        <th>#</th> 
                                        <th>Nombre</th> 
                                        <th>Edad</th> 
                                        <th>Pais</th>
                                        <th>E-mail</th>
                                        <th></th>
                                    </tr> 
                                </thead> 
                                <tbody> 
                                    <c:forEach items="${usuarios}" var="user">
                                        <tr> 
                                            <th scope="row"><c:out value="${user.id}"/></th>
                                            <td><c:out value="${user.nombre}"/></td>
                                            <td><c:out value="${user.edad}"/></td>
                                            <td><c:out value="${user.pais}"/></td>                               
                                            <td><c:out value="${user.email}"/></td>
                                            <td>
                                                <a href="#" class="btn btn-danger eliminar" data-id="${user.id}" data-nombre="${user.nombre}">
                                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                </a> 
                                                <a href="#" class="btn btn-primary actualizar" data-id="${user.id}">
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>