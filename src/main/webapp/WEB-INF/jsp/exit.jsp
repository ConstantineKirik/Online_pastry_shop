<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="auth">
    <h2>Вы уверены?</h2>

    <c:url value="/logout" var="logout"/>
    <sf:form method="post" action="${logout}">
        <input type="submit" value="Да, выйти"/>
    </sf:form>
    <c:url value="/" var="main"/>
    <sf:form method="get" action="${main}">
        <input type="submit" value="Остаться"/>
    </sf:form>
</div>

<%@include file="common/footer.jsp" %>