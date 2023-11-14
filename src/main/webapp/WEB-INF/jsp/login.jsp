<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<h2>Вход в систему</h2>

<c:url value="/loginPage" var="loginPage"/>
<sf:form mehtod="post" action="${loginPage}" >

    <p>
        <label>
        <input type="text" name="username" placeholder="Username" />
        </label>
    </p>

    <p>
        <label>
        <input type="password" name="password" placeholder="Password" />
        </label>
    </p>

    <input type="submit" value="Login" />

</sf:form>

    <h4><a href="/registrationUser">Зарегистрироваться</a></h4>

<%@include file="common/footer.jsp"%>