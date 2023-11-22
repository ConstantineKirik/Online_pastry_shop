<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="auth">

    <c:url value="/registration" var="registration"/>
    <sf:form method="post" action="${registration}" modelAttribute="registrationUser">

        <h2>Регистрация</h2>

        <sf:input type="text" path="username" placeholder="Username"></sf:input>
        <sf:errors path="username"></sf:errors>
        ${usernameError}

        <sf:input type="password" path="password" placeholder="Password"></sf:input>

        <sf:input type="password" path="confirmPassword" placeholder="Confirm your password"></sf:input>
        <sf:errors path="password"></sf:errors>
        ${passwordError}

        <sf:input type="text" path="mobileNumber" placeholder="Mobile number"></sf:input>

        <sf:input type="text" path="email" placeholder="Email"></sf:input>

        <input type="submit" value="Зарегистрироваться">

    </sf:form>
</div>
<%@include file="common/footer.jsp" %>