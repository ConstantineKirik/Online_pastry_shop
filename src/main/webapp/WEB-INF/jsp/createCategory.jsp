<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="addCategory">
<c:url value="/admin/createCategory" var="createCategory"/>
<sf:form method="post" action="${createCategory}" modelAttribute="addCategory">

    <h3>Создание категории</h3>

    <sf:input type="text" path="title" placeholder="Название категории"></sf:input>
    <sf:errors path="title"></sf:errors>
    ${titleError}

    <sf:input type="text" path="image" placeholder="Название картинки"></sf:input>

    <input type="submit" value="Создать">
</sf:form>
</div>

<%@include file="common/footer.jsp" %>