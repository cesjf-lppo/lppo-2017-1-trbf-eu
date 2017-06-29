<%@include file="../partialView/head.jspf" %>
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4 class="panel-title">Lista de todos os usuarios</h4>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Matricula</th>
                                    <th>Nome Completo</th>
                                    <th>E-mail</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="usuario" items="${usuarios}">
                                <tr>
                                    <th scope="row">${usuario.id}</th>
                                    <td>${usuario.nomeCompleto}</td>
                                    <td>${usuario.email}</td>
                                    <td><button class="btn btn-primary btn-sm">Editar</button> <button class="btn btn-danger btn-sm">Excluir</button></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
<%@include file="../partialView/body.jspf" %>