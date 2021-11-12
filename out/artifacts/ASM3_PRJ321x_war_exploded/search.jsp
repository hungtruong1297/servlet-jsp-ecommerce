<%--
  Created by IntelliJ IDEA.
  User: chai
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- Main problem: Where to put the result?
This method overides the attribute Products in Home.jsp and display it.--%>
<%--<form action="SearchController2" method="post">--%>
<%--    <input type="text" name="searchValue">--%>
<%--    <input type="submit" value="Search!">--%>
<%--</form>--%>


<div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
    <form action="SearchController2" class="site-block-top-search" method="post">
        <span class="icon icon-search2"></span>
        <input type="text" class="form-control border-0" placeholder="Search" name="searchValue">
    </form>
    <c:if test="${products.isEmpty()}" >
        <p class="alert-danger">Product is not found.</p>
    </c:if>
</div>