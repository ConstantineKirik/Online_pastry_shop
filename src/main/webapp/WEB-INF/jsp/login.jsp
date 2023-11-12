<%@include file="common/header.jsp"%>>

<h2>Вход в систему</h2>

<c:url value="/loginUser" var="loginProcessingUrl"/>
<form:form mehtod="post" action="${loginProcessingUrl}" >

    <p>
        User name: <label>
        <input type="text" name="username" />
    </label>
    </p>

    <p>
        Password: <label>
        <input type="password" name="password" />
    </label>
    </p>

    <input type="submit" value="Login" />

</form:form>
    <h4><a href="/registrationUser">Зарегистрироваться</a></h4>
<%@include file="common/footer.jsp"%>>