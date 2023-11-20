<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<br>

<h3>Детали заказа №${order.id}</h3>
<table>
    <tr>
        <th>Категория</th>
        <th>Название</th>
        <th>Цена</th>
    </tr>

    <c:forEach items="${order.products}" var="product">

        <tr>
            <td>${product.category.title}</td>
            <td>${product.title}</td>
            <td>${product.price}</td>
        </tr>

    </c:forEach>

</table>
    <h3>Итого: ${order.amount}</h3>

    <h4>Aдрес доставки: ул.${order.deliveryAddresses.street} д.${order.deliveryAddresses.house} кв.${order.deliveryAddresses.apartment}</h4>

    <h3>Статус: ${order.status}</h3>


<%@include file="common/footer.jsp"%>