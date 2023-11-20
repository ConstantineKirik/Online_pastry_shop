<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<sec:authorize access="hasRole('MANAGER')">

<a href="<c:url value="/showNewOrders"/> ">Показать новые заказы</a><br>

<c:forEach items="${newOrders}" var="order">
    Заказ №${order.id}
    <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Посмотреть детали заказа</a>
    <a href="<c:url value="/acceptOrder?id=${order.id}"/>">Принять</a>
</c:forEach>
    <br>
    <a href="<c:url value="/showFormedOrders"/> ">Показать сформированные заказы</a><br>

    <c:forEach items="${formedOrders}" var="order">
        Заказ №${order.id}
        <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Посмотреть детали заказа</a>
        <a href="<c:url value="/sentOrder?id=${order.id}"/>">Отправлен</a>
    </c:forEach>
    <br>
    <a href="<c:url value="/showDeliveredOrders"/> ">Показать доставленные заказы</a><br>

    <c:forEach items="${deliveredOrders}" var="order">
        Заказ №${order.id} - ${order.status}
        <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Посмотреть детали заказа</a>
        <a href="<c:url value="/closeOrder?id=${order.id}"/>">Закрыть</a>
    </c:forEach>
    <br>
</sec:authorize>


<sec:authorize access="hasRole('CONFECTIONER')">

    <a href="<c:url value="/showAcceptOrders"/> ">Показать принятые заказы</a><br>

    <c:forEach items="${acceptOrders}" var="order">
        Заказ №${order.id}
        <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Посмотреть детали заказа</a>
        <a href="<c:url value="/formedOrder?id=${order.id}"/>">Сформирован</a>
    </c:forEach>
    <br>
</sec:authorize>


<sec:authorize access="hasRole('COURIER')">

    <a href="<c:url value="/showSentOrders"/> ">Показать отправленные заказы</a><br>

    <c:forEach items="${sentOrders}" var="order">
        Заказ №${order.id}
        <a href="<c:url value="/detailsOrder?id=${order.id}"/>">Посмотреть детали заказа</a>
        <a href="<c:url value="/deliveredOrder?id=${order.id}"/>">Доставлен</a>
    </c:forEach>
    <br>
</sec:authorize>


<%@include file="common/footer.jsp"%>