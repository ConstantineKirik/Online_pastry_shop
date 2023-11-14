<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<br>

${category.title}
<c:forEach items="${category.products}" var="cake">

    ${cake.title} - ${cake.price} - <button>Добавить в корзину</button> -

    <a href="<c:url value="/deleteProduct?title=${cake.title}"/>">Удалить ${cake.title}</a><br>

</c:forEach>

<form action="<c:url value="/addProduct"/>">
    <button type="submit">Добавить пирожное</button>
</form>

<%@include file="common/footer.jsp"%>