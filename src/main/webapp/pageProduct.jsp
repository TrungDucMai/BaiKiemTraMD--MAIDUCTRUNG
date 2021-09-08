<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/1/2021
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductList</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        h2{
            text-align: center;
        }
        .test{
            background-color: #428bca;
            height: 100%;
        }
        .test2{
            padding-top: 40px;
            width: 100%;
            text-align: center;
            text-decoration: none;
            margin-right: 25px;
        }
        a{
            color: black;
            position: absolute;
            z-index: 0;
        }



    </style>


</head>
<body>

<div class="test">

    <div class="container">

        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach var="product" items="${productList}">
                <tbody>
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.color}</td>

                    <td> <a href="product?action=edit&id=${product.id}">Edit</a> </td>
                    <td><a href="product?action=delete&id=${product.id}">Delete</a></td>


                </tr>
                </tbody>
            </c:forEach>
        </table>

        <div>
          <tr> <td> <a href="product?action=create">Add New Product</a> </td>

               <td>< <a href="product?action=search">Search Product</a></tr> </td>
            <</div>
</body>
</html>
