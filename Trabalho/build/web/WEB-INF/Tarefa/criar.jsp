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
                                <label for="descricao">Descrição:</label>
                                <input class="form-control" type="text" id="descricao" name="descricao">
                                <label for="dataparaconclusao">Data para Conclusão:</label>
                                <p>
                                    <input type="date" id="dataparaconclusao" style="width: 100%;" name="dataparaconclusao">
                                </p>
                                
                                <label for="etiqueta">Etiqueta:</label>
                                <select class="form-control pull-right" id="etiqueta" name="etiqueta">
                                    <c:forEach var="etiqueta" items="${etiquetas}">
                                        <option value="${etiqueta.id}">${etiqueta.titulo}</option>
                                    </c:forEach>
                                </select>
                                
                                
                            </div>
                        </div>
                        <div class="panel-footer">
                            <button class="btn btn-primary" type="submit">Criar Tarefa</button>
                        </div>
                        </form>
                    </div>
                </div>
<%@include file="../partialView/body.jspf" %>