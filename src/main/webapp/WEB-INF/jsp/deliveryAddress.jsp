<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="deliveryAddress">
<c:url value="/submitDeliveryAddress" var="deliveryAddress"/>
<sf:form method="post" action="${deliveryAddress}" modelAttribute="deliveryAddress">

    <h2>Укажите адрес доставки</h2>

    <sf:input type="text" path="street" placeholder="Название улицы"></sf:input>

    <sf:input type="text" path="house" placeholder="Номер дома"></sf:input>

    <sf:input type="text" path="apartment" placeholder="Номер квартиры"></sf:input>

    <input type="submit" value="Продолжить оформление заказа">

</sf:form>
</div>

<%@include file="common/footer.jsp" %>