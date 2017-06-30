<%@include file="../partialView/head.jspf" %>
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <form action="FiltrarUsua" method="get">
                                <h4 style="margin-top: 0.5%;" class="panel-title pull-left">Lista de todos os usuarios</h4>
                                <div><button onClick="location.href = 'Listar'" type="button" style="margin-left: 1%; margin-top: 0.2%;" class="btn btn-default btn-sm pull-right">Zerar Filtro</button></div>
                                <div><button style="margin-left: 1%; margin-top: 0.2%;" type="submit" class="btn btn-success btn-sm pull-right">Filtrar</button></div>
                                <div>
                                    <select style="width: 20%;" class="form-control pull-right" id="usuario" name="usuario">
                                        <c:forEach var="usuario" items="${usuarios}">
                                            <option value="${usuario.id}">${usuario.nomeCompleto}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="clearfix"></div>
                            </form>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Titulo</th>
                                    <th>Dono</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="etiqueta" items="${etiquetas}">
                                <tr>
                                    <th scope="row">${etiqueta.id}</th>
                                    <td>${etiqueta.titulo}</td>
                                    <td>${etiqueta.autor.nomeCompleto}</td>
                                    <td><button class="btn btn-primary btn-sm" onclick="location.href='Editar?id=${etiqueta.id}'">Editar</button> <button class="btn btn-danger btn-sm" onclick="Excluir(${etiqueta.id},'${etiqueta.autor.nomeCompleto}')">Excluir</button></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
<script>
    function Excluir(id,nome)
    {
        if (confirm("Você deseja apagar a etiqueta do usuario "+nome+" ?"))
            location.href="Excluir?id="+id;
        else
            return 0;
    }
</script>
<%@include file="../partialView/body.jspf" %>