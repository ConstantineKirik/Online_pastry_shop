<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="auth">

    <h3>Вход в систему</h3>

    <c:url value="/login" var="login"/>
    <sf:form mehtod="post" action="${login}">

        <sf:errors path="blackList"></sf:errors>
        ${blackList}

        <input type="text" name="username" placeholder="Имя пользователя"/>
        <sf:errors path="usernameError"></sf:errors>
        ${usernameError}

        <input type="password" name="password" placeholder="Пароль"/>
        <sf:errors path="passwordError"></sf:errors>
        ${passwordError}

        <input type="submit" value="Войти"/>

    </sf:form>

    <h4><a href="/registrationUser">Зарегистрироваться</a></h4>
</div>

<%@include file="common/footer.jsp" %>