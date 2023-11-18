<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<h3>Ваш заказ</h3>

<table>
    <tr>
        <th></th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${bucket.bucketDetails}" var="detail">

        <tr>
            <td>${detail.title}</td>
            <td>${detail.amount} шт.</td>
            <td>${detail.sum}руб.</td>
        </tr>

    </c:forEach>
</table>

<h3>Итого к оплате: ${bucket.sum}руб.</h3><br>

<h4>Aдрес доставки: ул.${deliveryAddress.street} д.${deliveryAddress.house} кв.${deliveryAddress.apartment}</h4>

<c:url value="/orderPlaced" var="orderPlaced"/>
<sf:form mehtod="post" action="${orderPlaced}" modelAttribute="order">

    <input type="text" name="amount" value="${bucket.sum}"/>
    <input type="text" name="deliveryAddressesId" value="${deliveryAddressId}"/>

    <input type="submit" value="Подтвердить" />

</sf:form>

<a href="<c:url value="/orderPlaced"/>">Подтвердить</a>


<%@include file="common/footer.jsp"%>