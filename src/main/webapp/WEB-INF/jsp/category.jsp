<%@include file="common/header.jsp"%>>
${category.title}
<c:forEach items="${category.products}" var="cake">
    ${cake.title} - ${cake.price}<br>
</c:forEach>
<%@include file="common/footer.jsp"%>>