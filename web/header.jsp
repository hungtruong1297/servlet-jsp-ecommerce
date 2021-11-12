<%--
  Created by IntelliJ IDEA.
  User: chai
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="site-navbar" role="banner">
    <div class="site-navbar-top">
        <div class="container">
            <div class="row align-items-center">

                <jsp:include page="search.jsp"/>

                <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                    <div class="site-logo">
                        <a href="HomeController" class="js-logo-clone">Shoppers</a>
                    </div>
                </div>

                <div class="col-6 col-md-4 order-3 order-md-3 text-right">
                    <div class="site-top-icons">
                        <ul>
                            <li><a href="login.jsp"><span class="icon icon-person"></span></a></li>
                            <li>
                                <a href="cart.jsp" class="site-cart">
                                    <span class="icon icon-shopping_cart"></span>
                                </a>
                            </li>
                            <li class="d-inline-block d-md-none ml-md-0"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
            <ul class="site-menu js-clone-nav d-none d-md-block">
                <li>
                    <a href="HomeController">Home</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li><a href="#">Shop</a></li>
                <li><a href="#">Catalogue</a></li>
                <li><a href="#">New Arrivals</a></li>
            </ul>
        </div>
    </nav>
</header>
