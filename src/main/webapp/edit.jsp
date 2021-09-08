<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/24/2021
  Time: 9:42 AM
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
    <h2>
        <a href="product?action=product">Product list</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">

            <c:if test="${product != null}">
                <input type="hidden" name="id" value="${product.id}"/>
            </c:if>
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${product.name}"
                    />
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="${product.price}"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="${product.quantity}"
                    />
                </td>
            </tr>
            <tr>
                <th>Color</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="${product.color}"
                    />
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