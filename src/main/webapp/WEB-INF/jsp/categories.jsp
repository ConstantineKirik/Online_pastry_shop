<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<a href="<c:url value="/home"/>">На главную</a>
<br>
<br>

<c:forEach items="${categories}" var="category">

    <a href="<c:url value="/category?title=${category.title}"/>">${category.title}</a> &nbsp;&nbsp;

    <a href="<c:url value="/deleteCategory?id=${category.id}"/>">Удалить ${category.title}</a>
    <br>
    <br>

</c:forEach>

<form action="<c:url value="/addCategory"/>">
    <button type="submit">Добавить категорию</button>
</form>

<%@include file="common/footer.jsp"%>