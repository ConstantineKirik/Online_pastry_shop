<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="bucket">
    <c:set var="bucket" value="${bucketDTO.bucketDetails}" scope="page"/>
    <c:if test="${empty bucket}">
        <h4>Ваша корзина пуста!</h4>

        <a href="<c:url value="/catalog"/>">Перейти к покупкам</a>
    </c:if>

    <c:if test="${not empty bucket}">
        <table>
            <tr>
                <th>Название</th>
                <th>Кол-во</th>
                <th>Цена</th>
                <th>Сумма</th>
            </tr>
            <c:forEach items="${bucketDTO.bucketDetails}" var="detail">
                <tr>
                    <td>${detail.title}</td>
                    <td>${detail.amount}шт.</td>
                    <td>${detail.price}руб.</td>
                    <td>${detail.sum}руб.</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        Итого к оплате: ${bucketDTO.sum}руб.
        <br>
        <a href="<c:url value="/clearBucket"/>">Очистить корзину</a><br>
        <br>
        <a href="<c:url value="/deliveryAddress"/>">Перейти к оформлению заказа</a>

    </c:if>
</div>

<%@include file="common/footer.jsp" %>