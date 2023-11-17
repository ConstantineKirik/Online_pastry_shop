<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<table>
    <tr>
        <th>Название</th>
        <th>Кол-во</th>
        <th>Цена</th>
        <th>Сумма</th>
        <th></th>
    </tr>

<c:forEach items="${bucketDTO.bucketDetails}" var="detail">

    <tr>
        <td>${detail.title}</td>
        <td>${detail.amount}</td>
        <td>${detail.price}</td>
        <td>${detail.sum}</td>
        <td><a href="<c:url value="#"/>">Удалить из корзины</a><br></td>
    </tr>

</c:forEach>
</table>

<h3>Итого к оплате: ${bucketDTO.sum}</h3><br>

<a href="<c:url value="#"/>">Оформить заказ</a>

<%@include file="common/footer.jsp"%>