<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<br>
<h3>Управление катекориями</h3><br>

<form action="<c:url value="/addCategory"/>">
    <button type="submit">Добавить категорию</button>
</form>

<c:forEach items="${categories}" var="category">

    <a href="<c:url value="/category?title=${category.title}"/>">${category.title}</a>

    <a href="<c:url value="/deleteCategory?id=${category.id}"/>">Удалить</a><br>

</c:forEach>

<br>
<h3>Управление продуктами</h3><br>

<form action="<c:url value="/addProduct"/>">
    <button type="submit">Добавить продукт</button>
</form>

<table >
    <tr>
        <th>Название</th>
        <th>Цена</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${products}" var="product">

        <tr>
            <td>${product.title}</td>
            <td>${product.price}</td>

            <td><a href="<c:url value="#"/>">Изменить</a></td>
            <td><a href="<c:url value="/deleteProduct?id=${product.id}"/>">Удалить</a></td>
        </tr>

    </c:forEach>
</table>


<%@include file="common/footer.jsp"%>