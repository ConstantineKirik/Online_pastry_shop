<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<h3>Привет ${pageContext.request.userPrincipal.name}</h3>

<a href="/">Главная</a>
<a href="/categories">Каталог</a>
<a href="/categories">Заказы</a>
<a href="<c:url value="/bucket?username=${pageContext.request.userPrincipal.name}"/>">Корзина</a>

<a href="/logout">Выйти</a>

<%@include file="common/footer.jsp"%>
