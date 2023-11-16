<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<br>

${category.title}
<c:forEach items="${category.products}" var="product">

    ${product.title} - ${product.price} -

    <a href="<c:url value="/addBucket?id=${product.id}"/>">Добавить в корзину</a>

    <a href="<c:url value="/deleteProduct?id=${product.id}"/>">Удалить ${product.title}</a><br>

</c:forEach>

<form action="<c:url value="/addProduct"/>">
    <button type="submit">Добавить пирожное</button>
</form>

<%@include file="common/footer.jsp"%>