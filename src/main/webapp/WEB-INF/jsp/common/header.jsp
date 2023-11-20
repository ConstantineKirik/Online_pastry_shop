<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Sweet Oblivion</title>
</head>

<body>

<h3>Sweet Oblivion</h3>

<sec:authorize access="isAuthenticated()">
Привет ${pageContext.request.userPrincipal.name}! ;-)
</sec:authorize>

<a href="<c:url value="/"/>">Главная</a>
<a href="<c:url value="/categories"/>">Каталог</a>

<sec:authorize access="isAuthenticated()">
<a href="<c:url value="/orders"/>">Мои заказы</a>
<a href="<c:url value="/bucket"/>">Корзина</a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
<a href="<c:url value="/login"/>">Войти</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a href="<c:url value="/logout"/>">Выйти</a>
</sec:authorize>

<br>

<sec:authorize access="hasRole('ADMIN')">
<a href="<c:url value="/userManagement"/>">Управление пользователями</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
<a href="<c:url value="/productManagement"/>">Управление продуктами</a>
</sec:authorize>
<sec:authorize access="hasRole('MANAGER')">
<a href="<c:url value="/orderManagement"/>">Управление заказами</a>
</sec:authorize>
<sec:authorize access="hasRole('CONFECTIONER')">
<a href="<c:url value="/orderManagement"/>">Управление заказами</a>
</sec:authorize>
<sec:authorize access="hasRole('COURIER')">
<a href="<c:url value="/orderManagement"/>">Управление заказами</a>
</sec:authorize>

<br>






