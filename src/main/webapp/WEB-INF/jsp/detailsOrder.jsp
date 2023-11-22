<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="orders">
    Детали заказа №${order.id}
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
                <td>${product.price}руб.</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    Итого: ${order.amount}руб.
    <br>
    Aдрес доставки: ул.${order.deliveryAddresses.street} д.${order.deliveryAddresses.house}
    кв.${order.deliveryAddresses.apartment}
    <br>
    Статус: ${order.status}
</div>
<%@include file="common/footer.jsp" %>