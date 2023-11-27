<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<c:url value="/admin/applyChangesProduct?id=${product.id}" var="applyChangesProduct"/>
<sf:form method="post" action="${applyChangesProduct}" modelAttribute="updateProduct">

    <div class="updateProduct">
    <h3>Изменение продукта</h3>

    <sf:input type="text" path="title" placeholder="Новое название"></sf:input>
    <sf:errors path="title"></sf:errors>
    ${titleError}

    <sf:input type="text" path="description" placeholder="Новое описание"></sf:input>

    <sf:input type="text" path="price" placeholder="Новая цена"></sf:input>

    <input type="submit" value="Применить">

</sf:form>
</div>
<%@include file="common/footer.jsp" %>