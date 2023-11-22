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

<div class="header">
    <a href="<c:url value="/"/>">Главная</a>
    <a href="<c:url value="/catalog"/>">Каталог</a>

    <sec:authorize access="isAuthenticated()">
        <a href="<c:url value="/orders"/>">Мои заказы</a>
        <a href="<c:url value="/bucket"/>">Корзина</a>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <a href="<c:url value="/login"/>">Войти</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="<c:url value="/exit"/>">Выйти</a>
    </sec:authorize>
</div>

