<%-- 
    Document   : index
    Created on : 28/06/2017, 12:38:40
    Author     : savio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação</title>
        <script src="js/jquery.min.js"  type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container" style="margin-top: 7%;">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">Autentique-se antes de continuar</h4>
                        </div>
                        <form method="post">
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="login">Login:</label>
                                <input class="form-control" id="login" name="login" type="text">
                                <label for="senha">Senha:</label>
                                <input class="form-control" id="senha" name="senha" type="password">
                            </div>
                        </div>
                        <div class="panel-footer">
                            <button type="submit" class="btn btn-primary">Entrar</button>
                        </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </body>
</html>