<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="categories-management">
    <h3>Управление катекориями</h3>

    <form action="<c:url value="/admin/addCategory"/>">
        <button type="submit">Добавить категорию</button>
    </form>

    <c:forEach items="${categories}" var="category">

        <a href="<c:url value="/users/category?title=${category.title}"/>">${category.title}</a>

        <a href="<c:url value="/admin/deleteCategory?title=${category.title}"/>">Удалить</a><br>

    </c:forEach>
</div>

<div class="products-management">
    <h3>Управление продуктами</h3>

    <form action="<c:url value="/admin/addProduct"/>">
        <button type="submit">Добавить продукт</button>
    </form>

    <table>
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

                <td><a href="<c:url value="/admin/updateProduct?id=${product.id}"/>">Изменить</a></td>
                <td><a href="<c:url value="/admin/deleteProduct?id=${product.id}"/>">Удалить</a></td>
            </tr>

        </c:forEach>
    </table>
</div>

<%@include file="common/footer.jsp" %>