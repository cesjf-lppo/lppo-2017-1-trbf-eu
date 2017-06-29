<%@include file="partialView/head.jspf" %>
                <div class="col-md-3"></div>
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">Autentique-se antes de continuar</h4>
                        </div>
                        <form action="/Inicio" method="post">
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
<%@include file="partialView/body.jspf" %>