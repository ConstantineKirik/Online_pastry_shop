<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="addProduct">
<c:url value="/createProduct" var="createProduct"/>
<sf:form method="post" action="${createProduct}" modelAttribute="addProduct">

    <h3>Добавление продукта</h3>

    <sf:input type="text" path="title" placeholder="Название пироженки"></sf:input>
    <sf:errors path="title"></sf:errors>
    ${titleError}

    <sf:input type="text" path="category" placeholder="Категория"></sf:input>

    <sf:input type="text" path="description" placeholder="Описание"></sf:input>

    <sf:input type="text" path="price" placeholder="Цена"></sf:input>

    <input type="submit" value="Добавить">

</sf:form>
</div>

<%@include file="common/footer.jsp" %>