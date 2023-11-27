<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="management">
    <div class="orders-management">
    <sec:authorize access="hasRole('MANAGER')">

        <a href="<c:url value="/staff/showNewOrders"/> ">Новые</a>
        <a href="<c:url value="/staff/showDeliveredOrders"/> ">Доставленные</a><br>
        <br>
        <c:forEach items="${newOrders}" var="order">
            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/staff/acceptOrder?id=${order.id}"/>">Принять</a><br>
        </c:forEach>

        <c:forEach items="${deliveredOrders}" var="order">
            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/staff/closeOrder?id=${order.id}"/>">Закрыть</a><br>
        </c:forEach>

        </sec:authorize>

        <sec:authorize access="hasRole('CONFECTIONER')">

            <a href="<c:url value="/staff/showAcceptOrders"/> ">Принятые</a><br>
            <br>
            <c:forEach items="${acceptOrders}" var="order">
                <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
                <a href="<c:url value="/staff/formedOrder?id=${order.id}"/>">Готов</a><br>
            </c:forEach>
        </sec:authorize>

        <sec:authorize access="hasRole('COURIER')">

        <a href="<c:url value="/staff/showFormedOrders"/> ">Готовые</a>
        <a href="<c:url value="/staff/showSentOrders"/> ">Отправленные</a><br>
        <br>
        <c:forEach items="${formedOrders}" var="order">
            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/staff/sentOrder?id=${order.id}"/>">Отправлен</a><br>
        </c:forEach>

        <c:forEach items="${sentOrders}" var="order">
            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> - ${order.status} -
            <a href="<c:url value="/staff/deliveredOrder?id=${order.id}"/>">Доставлен</a><br>
        </c:forEach>
    </div>
    </sec:authorize>
</div>
<%@include file="common/footer.jsp" %>