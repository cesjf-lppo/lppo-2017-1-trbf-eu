<%@include file="../partialView/head.jspf" %>
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">Registrar Usuario</h4>
                        </div>
                        <form method="post">
                        <div class="panel-body">
                            
                            <div class="form-group">
                                <label for="titulo">Titulo:</label>
                                <input class="form-control" placeholder="Ex: Titulo" type="text" id="titulo" name="titulo" >
                                <label for="usuario">Usuario:</label>
                                <select class="form-control" id="usuario" name="usuario">
                                    <c:forEach var="usuario" items="${usuarios}">
                                        <option value="${usuario.id}">${usuario.nomeCompleto}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <button class="btn btn-primary" type="submit">Criar Etiqueta</button>
                        </div>
                        </form>
                    </div>
                </div>
<%@include file="../partialView/body.jspf" %>