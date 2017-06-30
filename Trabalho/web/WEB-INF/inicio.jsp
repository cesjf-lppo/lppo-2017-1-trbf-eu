<%@include file="partialView/head.jspf" %>
<div class="col-md-12">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h4 class="panel-title pull-left" style="margin-top: 0.5%;">KanBoard</h4>
            <div><button onClick="location.href = 'Tarefa/Criar'" type="button" style="margin-left: 1%; margin-top: 0.2%;" class="btn btn-success btn-sm pull-right">Criar Tarefa</button></div>
            <div class="clearfix"></div>
        </div>
        <table class="table">
            <c:forEach var="etiqueta" items="${etiquetas}">
                <tr>
                    <th>
                        ${etiqueta.titulo}
                    </th>
                </tr>
                <tr>
                    <c:forEach var="tarefa" items="${tarefas}">
                        <c:if test="${etiqueta.id == $tarefa.etiqueta.id}">
                            <td>${tarefa.id}</td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
                
        </table>
    </div>
</div>
<%@include file="partialView/body.jspf" %>