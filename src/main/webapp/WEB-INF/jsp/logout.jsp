<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<form method="post" action="<c:url value="/logout"/>">
    <h2>Вы уверены?</h2>
    <button type="submit">ДА</button>
</form>
<a href="<c:url value="/home"/>">Вернуться на главную</a>


<%@include file="common/footer.jsp"%>