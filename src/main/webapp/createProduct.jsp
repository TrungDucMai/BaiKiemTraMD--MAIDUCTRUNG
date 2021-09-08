<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/24/2021
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="nameProduct" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <input type="text" name="price" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>
                    <input type="text" name="quantity" id="country" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Color</th>
                <td>
                    <input type="text" name="color" id="country1" size="15"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>