<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="user-management">
    <div class="search">
        <c:url value="/admin/search" var="search"/>
        <sf:form method="post" action="${search}" modelAttribute="search">
            <h3>Поиск пользователей</h3>

            <sf:input type="text" path="username" placeholder="Имя пользователя"></sf:input>

            <sf:input type="text" path="mobileNumber" placeholder="Номер мобильного"></sf:input>

            <sf:input type="text" path="email" placeholder="Электронная почта"></sf:input>

            <sf:input type="text" path="status" placeholder="Статус"></sf:input>

            <input type="submit" value="Найти">

        </sf:form>
    </div>

    <table class="user-table">
        <tr>
            <th>Имя пользователя </th>
            <th> Статус </th>
            <th> Кол-во заказов</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="<c:url value="/admin/showUserDetails?id=${user.id}"/>">${user.username}</a></td>
                <td> ${user.status} </td>
                <td>${fn:length(user.orders)}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="common/footer.jsp" %>