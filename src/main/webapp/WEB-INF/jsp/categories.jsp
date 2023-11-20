<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<br>
<br>

<c:forEach items="${categories}" var="category">

    <a href="<c:url value="/category?title=${category.title}"/>">${category.title}</a> &nbsp;&nbsp;

</c:forEach>

<%@include file="common/footer.jsp"%>