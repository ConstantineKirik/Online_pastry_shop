<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<br>

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



<%@include file="common/footer.jsp"%>