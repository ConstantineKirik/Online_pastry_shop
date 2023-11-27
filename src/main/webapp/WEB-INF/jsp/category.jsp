<%@include file="common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="products">
    <c:forEach items="${category.products}" var="product">
    <div class="product">
        <img src="/images/${product.image}.png" width="220" height="270" alt=""/>
        <div class="text-product">
            <div class="product-title">
                    ${product.title}
            </div>

            <div class="product-price">
                Цена: ${product.price} руб.<br>
                <a href="<c:url value="/users/addBucket?id=${product.id}&title=${category.title}"/>">В корзину</a>
            </div>
        </div>
    </div>
    </c:forEach>
</div>
<%@include file="common/footer.jsp" %>