package controller;

import model.Products;
import service.products.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletProduct", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreateNewProduct (req, resp);
                break;
            case "edit":
                formEditProduct (req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            case "search" :
                formSearchProduct (req,resp);
                break;

            default:
                pageProduct(req, resp);
                break;
        }
    }

    private void formSearchProduct(HttpServletRequest req, HttpServletResponse resp) {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/search.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createProduct.jsp");
        try {
            dispatcher.forward(req, resp);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void formEditProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Products product= productService.findProductByID(id);
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pageProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Products> productsList = productService.showAllProducts();
        req.setAttribute("productList", productsList );
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pageProduct.jsp");
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewProduct(req, resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;


            default:
                pageProduct(req, resp);
                break;
        }
    }

    private void createNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");

        productService.saveNewProduct(name,price,quantity,color);
        try {
            resp.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
    }
    }


    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");

        productService.updateProduct(id,name,price,quantity,color);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
