<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="confirm-remove">
<c:if test="${not empty removeCategory}">
    Внимание!<br><br>
    При удалении категории также будет удалено все ее содержимое!<br><br>
    Вы действительно хотите удалить категорию ${removeCategory.title}?<br>
    <a href="<c:url value="/admin/confirmRemoveCategory?id=${removeCategory.id}"/>">Да</a>
    <a href="<c:url value="/admin/productManagement"/>">Нет</a>
</c:if>

<c:if test="${not empty removeProduct}">
    Вы действительно хотите удалить продукт ${removeProduct.title}?<br>
    <a href="<c:url value="/admin/confirmRemoveProduct?id=${removeProduct.id}"/>">Да</a>
    <a href="<c:url value="/admin/productManagement"/>">Нет</a>
</c:if>
</div>
<%@include file="common/footer.jsp" %>