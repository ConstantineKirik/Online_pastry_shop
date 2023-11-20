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
    </tr>

<c:forEach items="${category.products}" var="product">

    <tr>
        <td>${product.title}</td>
        <td>${product.price}</td>
        <td><a href="<c:url value="/addBucket?id=${product.id}"/>">Добавить в корзину</a></td>
    </tr>

</c:forEach>
</table>

<%@include file="common/footer.jsp"%>