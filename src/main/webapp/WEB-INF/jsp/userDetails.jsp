<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<br>

<h3>Пользователь №${user.id}</h3>

<h4>Имя пользователя: ${user.username}</h4>
<h4>Телефон: ${user.mobileNumber}</h4>
<h4>Email: ${user.email}</h4>
<h4>Кол-во заказов: ${fn:length(user.orders)}</h4>
<h4>Статус: ${user.status}</h4>

<c:url value="/statusUp?id=${user.id}" var="statusUp"/>
<sf:form method="post" action="${statusUp}" modelAttribute="change">

    <sf:input type="text" path="status" placeholder="Повысить до"></sf:input><br>

    <input type="submit" value="Повысить">

</sf:form>

<c:url value="/assignRole?id=${user.id}" var="assignRole"/>
<sf:form method="post" action="${assignRole}" modelAttribute="change">

    <sf:input type="text" path="role" placeholder="Назначить на"></sf:input><br>

    <input type="submit" value="Назначить">

</sf:form>


<%@include file="common/footer.jsp" %>