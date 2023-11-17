<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<c:url value="/createProduct" var="createProduct"/>
<sf:form method="post" action="${createProduct}" modelAttribute="addProduct">

    <h2>Добавление продукта</h2>

    <sf:input type="text" path="title" placeholder="Название пироженки"></sf:input><br>
    <sf:errors path="title"></sf:errors>
    ${titleError}<br>

    <sf:input type="text" path="category" placeholder="Категория"></sf:input><br>

    <sf:input type="text" path="description" placeholder="Описание"></sf:input><br>

    <sf:input type="text" path="price" placeholder="Цена"></sf:input><br>

    <input type="submit" value="Добавить">

</sf:form>

<%@include file="common/footer.jsp" %>