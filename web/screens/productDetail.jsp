<%-- 
    Document   : productDetail
    Created on : May 22, 2023, 2:54:53 AM
    Author     : kienk
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Durian Shop</title>
        <!--css-->
        <link rel="stylesheet" href="styles/nav-bar.css" type="text/css"/>
        <link rel="stylesheet" href="styles/footer.css" type="text/css"/>
        <link rel="stylesheet" href="styles/related-product.css" type="text/css"/>
        <link rel="stylesheet" href="styles/product-detail.css" type="text/css"/>
        <!-- Font family -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Shadows+Into+Light&display=swap"
            rel="stylesheet"
            />
        <!-- Favicon -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <body>
        <div class="header-container">
            <jsp:include page="../screens/navbar.jsp"></jsp:include>
            </div>
        </div>
        <hr />
        <div class="product-container">
            <h1 class="product-name">Buy ${productName}</h1>
        <div class="product-image">
            <c:forEach items="${image}" var="img">
                <a><img class="mySlides" src="img/${img.url}" alt=""></a>
                </c:forEach>
            <button class="btn-slide" id="pre-slide" onclick="moveImage(-1)">&#10094;</button>
            <button class="btn-slide" id="next-slide" onclick="moveImage(1)">&#10095;</button>
        </div>
        <div class="product-pick">
            <div class="pick-color">
                <h2>Pick your favorite</h2>
                <h3 id="color-name" style="color: black;">Color<c:if test="${not empty colorName}">
                        - ${colorName}
                    </c:if></h3>
                    <c:forEach items="${color}" var="c">
                    <button class="btn-color" id="${c.name}" style="background-color: ${c.hexCode}; border: 1px solid grey; border-radius: 50%; height: 20px; width: 20px;"></button>
                </c:forEach>
            </div>
            <div class="pick-storage disabled" id="storage-options">
                <h2>How much space do you need?</h2>
                <c:forEach items="${storage}" var="s">
                    <button class="storage" id="storage${s.id}">${s.storageSize}</button>
                </c:forEach>
            </div>
        </div>
    </div>
    <div id="add-to-cart-container" class="hidden">
        <div id="your-phone">
            <h2>Your new</h2>
            <h2>${productName}</h2>
            <h2 style="color: #86868b;">Just the way you</h2>
            <h2 style="color: #86868b;">want it.</h2>
        </div>
        <div id="your-price">
            <h3>${productName} ${storageSize} ${colorName}</h3>
            <c:if test="${variant.saleId==1}"><h3>$${variant.variantPrice}</h3></c:if>
            <c:if test="${variant.saleId!=1}"><h3><span style="text-decoration: line-through;">$${variant.variantPrice}</span> <span style="font-size: larger">$${priceSale}</span></h3></c:if>
                <hr style="border:1px solid grey; margin-top: 0"/>
            <c:if test="${variant.quantity != 0}">
                <a href="add-to-cart?id=${product.id}&colorName=${colorName}&storageId=${storageId}"><button>Add to cart</button></a></c:if>
                <c:if test="${variant.quantity == 0}">
                    <h3>This product is out of stock!</h3></c:if>
            </div>
            <div id="">
                <h3 style="margin-bottom: 2px"><i class="fa fa-truck"></i> Delivery:</h3>
                <p style="padding-left:15px; margin-top: 0px">${variant.quantity==0?"Out Stock":"In Stock"}<br/>
                    Free Shipping<br/>
                    <a href="#">Get delivery dates</a></p>
                <h3 style="margin-bottom: 2px"><i class="fa fa-shopping-bag"></i>Pick up:</h3>
                <p style="padding-left:15px; margin-top: 0px;">Availability: ${variant.quantity}</p>
            </div>
        </div>
        <hr />
        <div class="detail-container">
            <h2><span class="description">Description</span>&nbsp;<span class="review">Review</span></h2>
            <div class="des-container">
                <div class="description-content">
                    <div class="description-text"> 
                        <h3 style="color: red; text-align: center;">Feature</h3>
                    <c:forEach items="${description}" var="d">
                        <p> <span style="font-size: 1.8em;">&middot;</span> ${d}</p>
                    </c:forEach>
                </div>
                <div class="specification">
                    <h3 style="color: red; text-align: center;">Specifications</h3>
                    <p style="background-color: #E7E9EB; padding: 5px; border-radius: 10px;"> <span style="font-size: 1.8em;">&middot;</span> Screen: ${product.screen}</p>
                    <p> <span style="font-size: 1.8em;">&middot;</span> Camera: ${product.camera}</p>
                    <p style="background-color: #E7E9EB; padding: 5px; border-radius: 10px;"> <span style="font-size: 1.8em;">&middot;</span> Ram: ${product.ram}</p>
                    <p> <span style="font-size: 1.8em;">&middot;</span> Operating system: IOS</p>
                    <p style="background-color: #E7E9EB; padding: 5px; border-radius: 10px;"> <span style="font-size: 1.8em;">&middot;</span> Pin: ${product.pin}</p>
                    <p> <span style="font-size: 1.8em;">&middot;</span> Chipset: ${product.chipset}</p>
                    <p style="background-color: #E7E9EB; padding: 5px; border-radius: 10px;"> <span style="font-size: 1.8em;">&middot;</span> Screen Resolution: ${product.screenResolution}</p>
                </div>
            </div>
        </div>
        <div class="review-content">
            <p>Review Màn hình Dynamic Island - Sự biến mất của màn hình tafdfdfi thỏ thay thế bằng thiết kế viên thuốc, OLED 6,7 inch, hỗ trợ always-on display</p>
        </div>
    </div>
    <hr />
    <jsp:include page="../screens/relatedProduct.jsp"></jsp:include>

        <hr />
    <jsp:include page="../screens/footer.jsp"></jsp:include>
    <script src="js/productDetail.js"></script>
</body>
</html>