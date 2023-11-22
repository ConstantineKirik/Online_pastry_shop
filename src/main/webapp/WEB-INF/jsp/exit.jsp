<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="auth">
    <h2>Вы уверены?</h2>

    <c:url value="/logout" var="logout"/>
    <sf:form mehtod="post" action="${logout}">
        <input type="submit" value="Выйти"/>
    </sf:form>
    <c:url value="/" var="main"/>
    <sf:form mehtod="get" action="${main}">
        <input type="submit" value="Остаться"/>
    </sf:form>

</div>
<%@include file="common/footer.jsp" %>