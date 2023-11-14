<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>

    <c:url value="/registration" var="registration"/>
    <sf:form method="post" action="${registration}" modelAttribute="registrationUser">

        <h2>Регистрация</h2>

        <sf:input type="text" path="username" placeholder="Username"></sf:input><br>
        <sf:errors path="username"></sf:errors>
        ${usernameError}<br>

        <sf:input type="password" path="password" placeholder="Password"></sf:input><br><br>

        <sf:input type="password" path="confirmPassword" placeholder="Confirm your password"></sf:input><br>
        <sf:errors path="password"></sf:errors>
        ${passwordError}<br>

        <sf:input type="text" path="mobileNumber" placeholder="Mobile number"></sf:input><br><br>

        <sf:input type="text" path="email" placeholder="Email"></sf:input><br><br>

        <input type="submit" value="Зарегистрироваться">

    </sf:form>

<%@include file="common/footer.jsp" %>