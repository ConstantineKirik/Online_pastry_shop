<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="management">
    <sec:authorize access="hasRole('MANAGER')">
        <table>
            <tr>
                <th><a href="<c:url value="/showNewOrders"/> ">Новые заказы</a></th>
                <th><a href="<c:url value="/showDeliveredOrders"/> ">Доставленные заказы</a></th>
            </tr>
        </table>

        <c:forEach items="${newOrders}" var="order">
            <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/acceptOrder?id=${order.id}"/>">Принять</a><br>
        </c:forEach>

        <c:forEach items="${deliveredOrders}" var="order">
            <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/closeOrder?id=${order.id}"/>">Закрыть</a><br>
        </c:forEach>
    </sec:authorize>


    <sec:authorize access="hasRole('CONFECTIONER')">

        <table>
            <tr>
                <th><a href="<c:url value="/showAcceptOrders"/> ">Принятые заказы</a></th>
            </tr>
        </table>

        <c:forEach items="${acceptOrders}" var="order">
            <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/formedOrder?id=${order.id}"/>">Сформирован</a><br>
        </c:forEach>
    </sec:authorize>

    <sec:authorize access="hasRole('COURIER')">

        <table>
            <tr>
                <th><a href="<c:url value="/showFormedOrders"/> ">Сформированные заказы</a></th>
                <th><a href="<c:url value="/showSentOrders"/> ">Отправленные заказы</a></th>
            </tr>
        </table>

        <c:forEach items="${formedOrders}" var="order">
            <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/sentOrder?id=${order.id}"/>">Отправлен</a><br>
        </c:forEach>

        <c:forEach items="${sentOrders}" var="order">
            <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/deliveredOrder?id=${order.id}"/>">Доставлен</a><br>
        </c:forEach>
    </sec:authorize>
</div>
<%@include file="common/footer.jsp" %>