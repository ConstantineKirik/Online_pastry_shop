<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="categories">
    <dl>
        <dt>Категории:</dt>
        <c:forEach items="${categories}" var="category">

            <dd><a href="<c:url value="/category?title=${category.title}"/>">${category.title}</a></dd>
            &nbsp;&nbsp;
        </c:forEach>
    </dl>
</div>

<div class="products">
    <c:if test="${not empty category.products}">
        <dl>
            <dt>${category.title}: </dt>
        </dl>

        <table>
            <tr>
                <th>Название</th>
                <th>Цена</th>
                <th></th>
            </tr>

            <c:forEach items="${category.products}" var="product">

                <tr>
                    <td>${product.title}</td>
                    <td>${product.price}руб.</td>
                    <td><a href="<c:url value="/addBucket?id=${product.id}&title=${category.title}"/>">В корзину</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </c:if>
</div>

<%@include file="common/footer.jsp" %>