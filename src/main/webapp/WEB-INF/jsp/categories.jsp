<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<br>

<c:forEach items="${categories}" var="category">

    <a href="<c:url value="/category?title=${category.title}"/>">${category.title}</a>
    -----
    <a href="<c:url value="/deleteCategory?title=${category.title}"/>">Удалить ${category.title}</a><br>

</c:forEach>

<form action="<c:url value="/addCategory"/>">
    <button type="submit">Добавить категорию</button>
</form>


<%@include file="common/footer.jsp"%>