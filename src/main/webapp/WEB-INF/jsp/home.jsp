<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<h3>Привет ${pageContext.request.userPrincipal.name}</h3>

<a href="<c:url value="/"/>">Главная</a>
<a href="<c:url value="/categories"/>">Каталог</a>
<a href="<c:url value="#"/>">Заказы</a>
<a href="<c:url value="/bucket"/>">Корзина</a>

<a href="<c:url value="/logout"/>">Выйти</a>

<%@include file="common/footer.jsp"%>
