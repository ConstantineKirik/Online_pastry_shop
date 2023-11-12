<%@include file="common/header.jsp"%>>

<c:forEach items="${categories}" var="category">

    <a href="<c:url value="/category?title=${category.title}"/>">${category.title}</a><br>

</c:forEach>
<%@include file="common/footer.jsp"%>>