<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="management">
    <div class="orders-management">
        <sec:authorize access="hasRole('MANAGER')">
            <div class="left-list">
                <dl>
                    <dt>Новые:</dt>
                    <c:forEach items="${newOrders}" var="order">
                        <dd>
                            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> |
                            <a href="<c:url value="/staff/acceptOrder?id=${order.id}"/>">Принять</a>
                        </dd>
                    </c:forEach>
                </dl>
            </div>
            <div class="right-list">
                <dl>
                    <dt>Доставленые:</dt>
                    <c:forEach items="${deliveredOrders}" var="order">
                        <dd>
                            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> |
                            <a href="<c:url value="/staff/closeOrder?id=${order.id}"/>">Закрыть</a>
                        </dd>
                    </c:forEach>
                </dl>
            </div>
        </sec:authorize>

        <sec:authorize access="hasRole('CONFECTIONER')">
            <div class="left-list">
                <dl>
                    <dt>Принятые:</dt>
                    <c:forEach items="${acceptOrders}" var="order">
                        <dd>
                            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> |
                            <a href="<c:url value="/staff/formedOrder?id=${order.id}"/>">Готов</a>
                        </dd>
                    </c:forEach>
                </dl>
            </div>
        </sec:authorize>

        <sec:authorize access="hasRole('COURIER')">
            <div class="left-list">
                <dl>
                    <dt>Готовые:</dt>
                    <c:forEach items="${formedOrders}" var="order">
                        <dd>
                            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> |
                            <a href="<c:url value="/staff/sentOrder?id=${order.id}"/>">Забрал</a>
                        </dd>
                    </c:forEach>
                </dl>
            </div>
            <div class="right-list">
                <dl>
                    <dt>В пути:</dt>
                    <c:forEach items="${sentOrders}" var="order">
                        <dd>
                            <a href="<c:url value="/users/detailsOrder?id=${order.id}"/>">Заказ №${order.id}</a> |
                            <a href="<c:url value="/staff/deliveredOrder?id=${order.id}"/>">Доставлен</a>
                        </dd>
                    </c:forEach>
                </dl>
            </div>
        </sec:authorize>
    </div>
</div>

<%@include file="common/footer.jsp" %>