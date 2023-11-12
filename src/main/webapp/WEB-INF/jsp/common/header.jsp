<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Sweet Oblivion</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/src/main/resources/static/css/style.css"/>
</head>
<body>

<div class="title">Sweet Oblivion</div>

<ul class="menu">

<li><a href="/loginUser">Войти</a></li>
<li> <a href="/registrationUser">Зарегистрироваться</a></li>
<li><a href="/logout">Выйти</a></li>

</ul>

        <a href="/main">Главная</a>
        <a href="/categories">Категории товаров</a>
        <a href="/order">Заказ</a>
        <a href="/delivery">Доставка</a>
        <a href="/about_us">О нас</a>
        <a href="/bucket">Корзина</a>




