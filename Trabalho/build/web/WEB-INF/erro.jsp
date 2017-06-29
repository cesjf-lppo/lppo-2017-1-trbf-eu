<%-- 
    Document   : index
    Created on : 28/06/2017, 12:38:40
    Author     : savio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ops</title>
        <script src="js/jquery.min.js"  type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">KanClient System</a>
                </div>
            </div>
        </nav>
        <div class="container" style="margin-top: 7%; padding-left: 5px; padding-right: 5px;">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <button onClick="window.history.go(-1);" class="btn btn-danger pull-left" style="margin-right: 7%;">Voltar</button>
                            <h4>Ocorreu um erro inesperado!!!</h4>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav class="nav navbar-default navbar-fixed-bottom">
            <div class="container">
                <p class="navbar-text">Sistema feito pelo aluno <a href="mailto:saviom.cedo@hotmail.com" class="navbar-link"><strong>Savio Macedo</strong></a></p>
            </div>
        </nav>
    </body>
</html>