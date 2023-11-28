<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="popular">
    <p>Популярное</p>
    <c:forEach items="${popular}" var="product">
        <div class="product">
            <img src="/images/${product.image}.png" width="220" height="270" alt=""/>
            <div class="product-text">
                <div class="product-title">
                        ${product.title}
                </div>

                <div class="product-price">
                    Цена: ${product.price} руб.<br>
                    <a href="<c:url value="/users/addBucket?id=${product.id}&title=${product.category.title}"/>">В
                        корзину</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<%@include file="common/footer.jsp" %>