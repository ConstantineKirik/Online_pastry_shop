<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="management">
<sec:authorize access="hasRole('ADMIN')">
    <a href="<c:url value="/userManagement"/>">Управление пользователями</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a href="<c:url value="/productManagement"/>">Управление продуктами</a>
</sec:authorize>
<sec:authorize access="hasRole('MANAGER')">
    <a href="<c:url value="/orderManagement"/>">Рабочая вкладка</a>
</sec:authorize>
<sec:authorize access="hasRole('CONFECTIONER')">
    <a href="<c:url value="/orderManagement"/>">Рабочая вкладка</a>
</sec:authorize>
<sec:authorize access="hasRole('COURIER')">
    <a href="<c:url value="/orderManagement"/>">Рабочая вкладка</a>
</sec:authorize>
</div>



<%@include file="common/footer.jsp"%>