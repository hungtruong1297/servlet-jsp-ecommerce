<%--
  Created by IntelliJ IDEA.
  User: chai
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Product Information</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">


    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>
<jsp:include page="header.jsp"/>
<div class="site-section">
    <div class="container">
        <c:forEach items="${productDetail}" var="o" >
        <div class="row">
            <div class="col-md-6">
                <img src="${o.src}" alt="Image" class="img-fluid">
            </div>
            <div class="col-md-6">
                <h2 class="text-black">${o.name}</h2>
                <p>Description: ${o.description}</p>
                <p>Brand: ${o.brand}</p>
                <p>Type: ${o.type}</p>
                <p><strong class="text-primary h4">${o.price}</strong></p>
                <p><a href="AddToCartController?action=add&id=${o.id}" class="buy-now btn btn-sm btn-primary">Add To Cart</a></p>

            </div>
        </div>
        </c:forEach>

    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>