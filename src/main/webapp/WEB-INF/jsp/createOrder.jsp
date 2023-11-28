<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="confirm-order">
    Ваш заказ успешно оформлен!
    <br>
    С вами свяжется наш сотрудник для подтверждения информации.
    <br>
    Посмотреть статус вашего заказа вы можете <a href="<c:url value="/users/orders"/>">здесь</a>
    <br>
    <a href="<c:url value="/"/>">Перейти на главную</a>
</div>

<%@include file="common/footer.jsp" %>