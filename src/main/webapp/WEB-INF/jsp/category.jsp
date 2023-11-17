<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<br>
${category.title}
<br>

<table >
    <tr>
        <th>Название</th>
        <th>Цена</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>

<c:forEach items="${category.products}" var="product">

    <tr>
        <td>${product.title}</td>
        <td>${product.price}</td>
        <td><a href="<c:url value="/addBucket?id=${product.id}"/>">Добавить в корзину</a></td>
        <td><a href="<c:url value="#"/>">Изменить ${product.title}</a></td>
        <td><a href="<c:url value="/deleteProduct?id=${product.id}"/>">Удалить ${product.title}</a></td>
    </tr>
    <br>
    <br>

</c:forEach>
</table>

<form action="<c:url value="/addProduct"/>">
    <button type="submit">Добавить пирожное</button>
</form>

<%@include file="common/footer.jsp"%>