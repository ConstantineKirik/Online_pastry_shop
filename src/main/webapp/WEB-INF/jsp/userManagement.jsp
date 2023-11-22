<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="userManagement">
<a href="<c:url value="/showAllUsers?status=NEW"/>">New</a>
<a href="<c:url value="/showAllUsers?status=SILVER"/>">Silver</a>
<a href="<c:url value="/showAllUsers?status=GOLD"/>">Gold</a>
<a href="<c:url value="/showAllUsers?status=PLATINUM"/>">Platinum</a>
<a href="<c:url value="/showAllUsers?status=STAFF"/>">STAFF</a>
<br>
<br>

<c:forEach items="${users}" var="user">
    <a href="<c:url value="/showUserDetails?id=${user.id}"/>">${user.username}</a>
    Кол-во заказов: ${fn:length(user.orders)} <br>
</c:forEach>
</div>

<%@include file="common/footer.jsp" %>