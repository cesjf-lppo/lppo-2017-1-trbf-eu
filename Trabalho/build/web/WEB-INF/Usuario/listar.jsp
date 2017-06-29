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
                                    <th scope="row"><a href="Editar?id=${usuario.id}">${usuario.id}</a></th>
                                    <td>${usuario.nomecompleto}</td>
                                    <td>${usuario.email}</td>
                                    <td><a href="Excluir?id=${usuario.id}">&#128465;</a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
<%@include file="../partialView/body.jspf" %>