<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="orders">
<c:set var="orders" value="${orders}" scope="page"/>
<c:if test="${empty orders}">

    <h4>У вас пока нет заказов для отслеживания</h4><br>

    <a href="<c:url value="/categories"/>">Перейти к покупкам</a>
</c:if>

<c:if test="${not empty orders}">
    <table>
        <tr>
            <th>Номер заказа</th>
            <th>Статус</th>
            <th></th>
        </tr>

        <c:forEach items="${orders}" var="order">

            <tr>
                <td>${order.id}</td>
                <td>${order.status}</td>
                <td><a href="<c:url value="/detailsOrder?id=${order.id}"/>">Посмотреть детали заказа</a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>
</div>

<%@include file="common/footer.jsp"%>