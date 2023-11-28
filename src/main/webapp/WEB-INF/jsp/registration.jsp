<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="auth">

    <c:url value="/registration" var="registration"/>
    <sf:form method="post" action="${registration}" modelAttribute="registrationUser">

        <h3>Регистрация</h3>

        <sf:input type="text" path="username" placeholder="Имя пользователя"></sf:input>
        <sf:errors path="username"></sf:errors>
        ${usernameError}

        <sf:input type="password" path="password" placeholder="Пароль"></sf:input>

        <sf:input type="password" path="confirmPassword" placeholder="Подтверждение пароля"></sf:input>
        <sf:errors path="password"></sf:errors>
        ${passwordError}

        <sf:input type="text" path="mobileNumber" placeholder="Номер мобильного"></sf:input>
        <sf:errors path="mobileNumber"></sf:errors>
        ${mobileNumberError}

        <sf:input type="text" path="email" placeholder="Электронная почта"></sf:input>
        <sf:errors path="email"></sf:errors>
        ${emailError}

        <input type="submit" value="Зарегистрироваться">

    </sf:form>
</div>
<%@include file="common/footer.jsp" %>