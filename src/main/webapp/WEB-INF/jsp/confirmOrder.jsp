<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="confirmOrder">
    Ваш заказ

    <table>
        <tr>
            <th>Название</th>
            <th>Кол-во</th>
            <th>Цена за ед.</th>
            <th>Сумма</th>
        </tr>

        <c:forEach items="${bucket.bucketDetails}" var="detail">

            <tr>
                <td>${detail.title}</td>
                <td>${detail.amount} шт.</td>
                <td>${detail.price} руб.</td>
                <td>${detail.sum}руб.</td>
            </tr>

        </c:forEach>
    </table>
    <br>
    Итого к оплате: ${bucket.sum}руб.
    <br><br>
    Aдрес доставки:<br> ул.${deliveryAddress.street} д.${deliveryAddress.house} кв.${deliveryAddress.apartment}

    <c:url value="/createOrder" var="createOrder"/>
    <sf:form mehtod="post" action="${createOrder}" modelAttribute="order">

        <input type="hidden" name="amount" value="${bucket.sum}"/>
        <input type="hidden" name="deliveryAddressesId" value="${deliveryAddressId}"/>
        <br>
        <input type="submit" value="Подтвердить"/>

    </sf:form>
</div>

<%@include file="common/footer.jsp" %>