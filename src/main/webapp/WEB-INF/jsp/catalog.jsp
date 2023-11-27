<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<div class="categories">

    <c:forEach items="${categories}" var="category">
        <div class="category">
            <a href="<c:url value="/users/category?title=${category.title}"/>"><img src="/images/${category.image}.png" width="220" height="270" alt=""></a>
            <div class="text-category">
                ${category.title}
            </div>
        </div>
    </c:forEach>

</div>

<%@include file="common/footer.jsp" %>