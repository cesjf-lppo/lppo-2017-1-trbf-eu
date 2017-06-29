<%@include file="../partialView/head.jspf" %>
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">Registrar Usuario</h4>
                        </div>
                        <form method="post">
                        <div class="panel-body">
                            
                            <div class="form-group">
                                <label for="nome">Nome Completo:</label>
                                <input class="form-control" placeholder="Fulano da Silva Sauro" type="text" id="nome" name="nome" >
                                <label for="email">E-mail:</label>
                                <input type="email" placeholder="fulano.sauro@exemplo.com" id="email" class="form-control" name="email">
                                <label for="senha">Senha:</label>
                                <input type="password" placeholder="**********" id="senha" class="form-control" name="senha">
                            </div>
                        </div>
                        <div class="panel-footer">
                            <button class="btn btn-primary" >Cadastrar Usuario</button>
                        </div>
                        </form>
                    </div>
                </div>
<%@include file="../partialView/body.jspf" %>