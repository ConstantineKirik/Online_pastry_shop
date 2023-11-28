<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="user-management">

    <a href="<c:url value="/admin/showAllUsers?status=STAFF"/>">Staff</a>
    <a href="<c:url value="/admin/showAllUsers?status=NEW"/>">New</a>
    <a href="<c:url value="/admin/showAllUsers?status=SILVER"/>">Silver</a>
    <a href="<c:url value="/admin/showAllUsers?status=GOLD"/>">Gold</a>
    <a href="<c:url value="/admin/showAllUsers?status=PLATINUM"/>">Platinum</a>
    <a href="<c:url value="/admin/showAllUsers?status=BLACKLIST"/>">Black List</a>
    <br>
    <br>
    <c:forEach items="${users}" var="user">
        <a href="<c:url value="/admin/showUserDetails?id=${user.id}"/>">${user.username}</a>
        Кол-во заказов: ${fn:length(user.orders)} <br>
    </c:forEach>
</div>

<%@include file="common/footer.jsp" %>