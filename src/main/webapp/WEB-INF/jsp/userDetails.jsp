<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="user-details">
    <dl class="attrs">
        <dt>Пользователь:</dt>
        <dd>№${user.id}</dd>

        <dt>Имя пользователя:</dt>
        <dd>${user.username}</dd>

        <dt>Телефон:</dt>
        <dd>+${user.mobileNumber}</dd>

        <dt>Email:</dt>
        <dd>${user.email}</dd>

        <dt>Кол-во заказов:</dt>
        <dd>${fn:length(user.orders)}</dd>

        <dt>Статус:</dt>
        <dd>${user.status}</dd>
    </dl>

    <c:url value="/admin/statusUp?id=${user.id}" var="statusUp"/>
    <sf:form method="post" action="${statusUp}" modelAttribute="change">
        <sf:input type="text" path="status" placeholder="Повысить до"></sf:input>
        <input type="submit" value="Повысить">
    </sf:form>

    <c:url value="/admin/assignRole?id=${user.id}" var="assignRole"/>
    <sf:form method="post" action="${assignRole}" modelAttribute="change">
        <sf:input type="text" path="role" placeholder="Назначить на роль"></sf:input>
        <input type="submit" value="Назначить">
    </sf:form>
</div>

<%@include file="common/footer.jsp" %>