<%--
  Created by IntelliJ IDEA.
  User: chai
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pay</title>
</head>
<body>

<div class="container">
    <div class="row text-center">
        <div class="col-lg-4  mx-auto">
            <form action="PayController" method="POST"> <!-- For better 'security', use POST instead of GET-->
                <div class="form-group">
                    <label for="name">Username:</label>
                    <input type="text" class="form-control" placeholder="Username" id="name" name="name"
                           required>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" placeholder="Your address" id="address"
                           name="address" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit Order</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
