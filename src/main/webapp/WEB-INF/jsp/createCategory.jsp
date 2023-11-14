<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<c:url value="/createCategory" var="createCategory"/>
<sf:form method="post" action="${createCategory}" modelAttribute="addCategory">

    <h2>Создание категории</h2>

    <sf:input type="text" path="title" placeholder="Название категории"></sf:input><br>
    <sf:errors path="title"></sf:errors>
    ${titleError}<br>

    <input type="submit" value="Создать">

</sf:form>

<%@include file="common/footer.jsp" %>