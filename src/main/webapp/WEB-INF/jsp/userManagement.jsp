<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<br>

<table >
    <tr>
        <th><a href="<c:url value="/showAllClient"/>">Показать всех</a></th>
        <th><a href="<c:url value="/showAllUsers?status=NEW"/>">New</a></th>
        <th><a href="<c:url value="/showAllUsers?status=SILVER"/>">Silver</a></th>
        <th><a href="<c:url value="/showAllUsers?status=GOLD"/>">Gold</a></th>
        <th><a href="<c:url value="/showAllUsers?status=PLATINUM"/>">Platinum</a></th>
    </tr>

    <tr>
        <c:if test="${users.size() > 0}">
            <th>
                <c:forEach items="${users}" var="user">
                    ${user.username} ${fn:length(user.orders)} ${user.status}<br>
                </c:forEach>
            </th>
        </c:if>
        <c:if test="${usersWithStatus.size() > 0}">
            <th>
                <c:forEach items="${usersWithStatus}" var="user">
                    ${user.username} ${fn:length(user.orders)} <br>
                </c:forEach>
            </th>
        </c:if>
        <c:if test="${usersWithStatus.size() > 0}">
            <th>
                <c:forEach items="${usersWithStatus}" var="user">
                    ${user.username} ${fn:length(user.orders)} <br>
                </c:forEach>
            </th>
        </c:if>
        <c:if test="${usersWithStatus.size() > 0}">
            <th>
                <c:forEach items="${usersWithStatus}" var="user">
                    ${user.username} ${fn:length(user.orders)} <br>
                </c:forEach>
            </th>
        </c:if>
        <c:if test="${usersWithStatus.size() > 0}">
            <th>
                <c:forEach items="${usersWithStatus}" var="user">
                    ${user.username} ${fn:length(user.orders)} <br>
                </c:forEach>
            </th>
        </c:if>
    </tr>
</table>


<%@include file="common/footer.jsp" %>