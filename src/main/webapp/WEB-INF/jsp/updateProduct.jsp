<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<c:url value="/applyChangesProduct?id=${product.id}" var="applyChangesProduct"/>
<sf:form method="post" action="${applyChangesProduct}" modelAttribute="updateProduct">

    <h2>Изменение продукта</h2>

    <sf:input type="text" path="title" placeholder="Новое название"></sf:input><br>
    <sf:errors path="title"></sf:errors>
    ${titleError}<br>

    <sf:input type="text" path="description" placeholder="Новое описание"></sf:input><br>

    <sf:input type="text" path="price" placeholder="Новая цена"></sf:input><br>

    <input type="submit" value="Применить">

</sf:form>

<%@include file="common/footer.jsp" %>