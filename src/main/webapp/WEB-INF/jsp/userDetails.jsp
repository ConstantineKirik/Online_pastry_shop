<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="userDetails">
    <dl>
        <dt>Пользователь №${user.id}</dt>
            <dd>Имя пользователя: ${user.username}</dd>
            <dd>Телефон: ${user.mobileNumber}</dd>
            <dd>Email: ${user.email}</dd>
            <dd>Кол-во заказов: ${fn:length(user.orders)}</dd>
            <dd>Статус: ${user.status}</dd>
            <dd></dd>
    </dl>

<c:url value="/statusUp?id=${user.id}" var="statusUp"/>
<sf:form method="post" action="${statusUp}" modelAttribute="change">

    <sf:input type="text" path="status" placeholder="Повысить до"></sf:input>

    <input type="submit" value="Повысить">

</sf:form>

<c:url value="/assignRole?id=${user.id}" var="assignRole"/>
<sf:form method="post" action="${assignRole}" modelAttribute="change">

    <sf:input type="text" path="role" placeholder="Назначить на роль"></sf:input>

    <input type="submit" value="Назначить">

</sf:form>
</div>

<%@include file="common/footer.jsp" %>