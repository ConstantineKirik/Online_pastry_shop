<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<c:url value="/admin/applyChangesProduct?id=${product.id}" var="applyChangesProduct"/>
<sf:form method="post" action="${applyChangesProduct}" modelAttribute="updateProduct">

    <div class="update-product">
        <h3>Изменение продукта</h3>

        <sf:input type="text" path="title" placeholder="Новое название"></sf:input>
        <sf:errors path="title"></sf:errors>
            ${titleError}

        <sf:input type="text" path="description" placeholder="Новое описание"></sf:input>

        <sf:input type="text" path="price" placeholder="Новая цена"></sf:input>

        <sf:input type="text" path="image" placeholder="Новая картинка"></sf:input>

        <input type="submit" value="Применить">
    </div>
</sf:form>

<%@include file="common/footer.jsp" %>