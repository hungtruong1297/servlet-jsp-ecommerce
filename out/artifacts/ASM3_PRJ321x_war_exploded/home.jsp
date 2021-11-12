<%--
  Created by IntelliJ IDEA.
  User: chai
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%--<head>--%>
<%--    <title>Home</title>--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--</head>--%>
<head>
    <title>Home</title>
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

<jsp:include page="header.jsp"/>

<body>


<%--Templates--%>
<div class="site-section">
    <div class="container">

        <div class="row mb-5">
            <div class="col-md-9 order-2">

                <div class="row">
                    <div class="col-md-12 mb-5">

                        <div class="row mb-5">

                            <c:forEach items="${products}" var="o">
                                <div class="col-sm-6 col-lg-4 mb-4">
                                    <div class="block-4 text-center border">
                                        <figure class="block-4-image">
                                            <a href="InformationProductController?id=${o.id}"><img src="${o.src}"
                                                                                                   alt="Image placeholder"
                                                                                                   class="img-fluid"></a>
                                        </figure>
                                        <div class="block-4-text p-4">
                                            <h3><a href="InformationProductController?id=${o.id}">${o.name}</a></h3>
                                            <p class="mb-0">${o.description}</p>
                                            <p class="text-primary font-weight-bold">${o.price}</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                        <div class="row aos-init" data-aos="fade-up">
                            <div class="col-md-12 text-center">
                                <div class="site-block-27">
                                    <ul>
                                        <li><a href="#">&lt;</a></li>
                                        <li class="active"><span>1</span></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">&gt;</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

<%--                CATEGORIES--%>

            </div>
            <%--            added--%>
            <div class="col-md-3 order-1 mb-5 mb-md-0">
                <div class="border p-4 rounded mb-4">
                    <div class="mb-4">
                        <h3 class="mb-3 h6 text-uppercase text-black d-block">Price</h3>
                        <label for="s_sm" class="d-flex">
                            <input type="checkbox" id="s_sm" class="mr-2 mt-1"> <span class="text-black"> Less than 10mil (2,319)</span>
                        </label>
                        <label for="s_md" class="d-flex">
                            <input type="checkbox" id="s_md" class="mr-2 mt-1"> <span class="text-black">More than 10mil (1,702)</span>
                        </label>
                        <label for="s_lg" class="d-flex">
                            <input type="checkbox" id="s_lg" class="mr-2 mt-1"> <span class="text-black">More than 30mil (1,458)</span>
                        </label>
                    </div>

                    <div class="mb-4">
                        <h3 class="mb-3 h6 text-uppercase text-black d-block">Color</h3>
                        <a href="#" class="d-flex color-item align-items-center">
                            <span class="bg-danger color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Red (2,429)</span>
                        </a>
                        <a href="#" class="d-flex color-item align-items-center">
                            <span class="bg-success color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Green (2,298)</span>
                        </a>
                        <a href="#" class="d-flex color-item align-items-center">
                            <span class="bg-info color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Blue (1,075)</span>
                        </a>
                        <a href="#" class="d-flex color-item align-items-center">
                            <span class="bg-primary color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Purple (1,075)</span>
                        </a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>

</body>

</html>