<%@include file="common/header.jsp"%>>
<div>
    <form action="/registration">
        <h2>Регистрация</h2>

            <label>Enter username: </label><br>
            <input type="text" name="username"><br>
            <errors path="username"></errors>
                ${usernameError}
            <br>

            <label>Enter password: </label><br>
            <input type="password" name="password"><br>
            <br>

            <label>Confirm your password: </label><br>
            <input type="password" name="confirmPassword"><br>
            <errors path="password"></errors>
                ${passwordError}
            <br>

            <label>Enter mobile number: </label><br>
            <input type="text" name="mobileNumber"><br>
            <br>

            <label>Enter email: </label><br>
            <input type="text" name="email"><br>
            <br>

            <input type="submit" value="Зарегистрироваться">
    </form>

</div>
<%@include file="common/footer.jsp"%>>