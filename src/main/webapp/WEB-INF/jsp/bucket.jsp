<%@include file="common/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<c:forEach items="${bucketDTO.bucketDetails}" var="detail">

    ${detail.title} - ${detail.amount} - ${detail.price} - ${detail.sum}<br>

</c:forEach>

<h3>Итого: ${bucketDTO.sum}</h3><br>

<a href="/order">Оформить заказ</a>

<%@include file="common/footer.jsp"%>