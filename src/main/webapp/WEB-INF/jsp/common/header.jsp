<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Sweet Oblivion</title>
    <link rel="stylesheet" href="/css/main.css"/>
    <link rel="stylesheet" href="/css/link.css"/>
</head>
<body>

<p class="logo">Sweet Oblivion</p>

<div class="time-works">
    <dl>
        <dt>Работаем:</dt>
        <dd>пн-пт: с 9:00 до 18:00</dd>
        <dd>сб,вс: выходной</dd>
    </dl>
</div>

<div class="header">
    <a href="<c:url value="/"/>">Главная</a>
    <a href="<c:url value="/catalog"/>">Каталог</a>

    <sec:authorize access="isAuthenticated()">
        <a href="<c:url value="/users/orders"/>">Мои заказы</a>
        <a href="<c:url value="/users/bucket"/>">Корзина</a>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <a href="<c:url value="/login"/>">Войти</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="<c:url value="/exit"/>">Выйти</a>
    </sec:authorize>
</div>

<div class="management">
    <sec:authorize access="hasRole('ADMIN')">
        <a href="<c:url value="/admin/userManagement"/>">Пользователи</a>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <a href="<c:url value="/admin/productManagement"/>">Продукция</a>
    </sec:authorize>
    <sec:authorize access="hasRole('MANAGER')">
        <a href="<c:url value="/staff/orderManagement"/>">Рабочая вкладка</a>
    </sec:authorize>
    <sec:authorize access="hasRole('CONFECTIONER')">
        <a href="<c:url value="/staff/orderManagement"/>">Рабочая вкладка</a>
    </sec:authorize>
    <sec:authorize access="hasRole('COURIER')">
        <a href="<c:url value="/staff/orderManagement"/>">Рабочая вкладка</a>
    </sec:authorize>
</div>