<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="auth">

    <h2>Вход в систему</h2>

    <c:url value="/login" var="login"/>
    <sf:form mehtod="post" action="${login}">

        <input type="text" name="username" placeholder="Username"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="submit" value="Войти"/>

    </sf:form>

    <h4><a href="/registrationUser">Зарегистрироваться</a></h4>
</div>
<%@include file="common/footer.jsp" %>