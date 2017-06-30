<%@include file="../partialView/head.jspf" %>
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">Editar Etiqueta</h4>
                        </div>
                        <form method="post">
                        <div class="panel-body">
                            
                            <div class="form-group">
                                <label for="etiqueta">Identificador da Etiqueta: ${etiqueta.id}</label>
                                <input type="hidden" class="form-control" name="etiqueta" id="etiqueta" value="${etiqueta.id}">
                                <p><label for="titulo">Titulo:</label>
                                <input class="form-control" placeholder="Fulano da Silva Sauro" value="${etiqueta.titulo}" type="text" id="titulo" name="titulo" >
                            </div>
                        </div>
                        <div class="panel-footer">
                            <button class="btn btn-primary" type="submit" >Salvar Edição</button>
                        </div>
                        </form>
                    </div>
                </div>
<%@include file="../partialView/body.jspf" %>