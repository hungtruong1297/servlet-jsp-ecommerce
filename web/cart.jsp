<%--
  Created by IntelliJ IDEA.
  User: chai
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Cart</title>
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
        <div class="row mb-5">
            <form class="col-md-12" method="post">
                <div class="site-blocks-table">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="product-thumbnail">Image</th>
                            <th class="product-name">Product</th>
                            <th class="product-price">Price</th>
                            <th class="product-quantity">Quantity</th>
                            <th class="product-total">Total</th>
                            <th class="product-remove">Remove</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="c" items="${sessionScope.cart.items}">

                        <tr>
                            <td class="product-thumbnail">
                                <img src="${c.src}" alt="Image" class="img-fluid">
                            </td>
                            <td class="product-name">
                                <h2 class="h5 text-black">${c.name}</h2>
                            </td>
                            <td>${c.price}</td>
                            <td>${c.number}</td>
                            <td>---</td>
                            <td><a href="#" class="btn btn-primary btn-sm">X</a></td>
                        </tr>
                        </tbody>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>

        <jsp:include page="pay.jsp"/>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>


