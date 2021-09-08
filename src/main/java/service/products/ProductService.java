package service.products;

import config.ConnectMySQL;
import model.Products;

import javax.naming.ldap.PagedResultsControl;
import java.awt.event.PaintEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    Connection connection = ConnectMySQL.getConnection();
    public static final String INSERT_INTO_PRODUCT = "insert into products" + "(name,price,quantity,color) VALUES" + "(?,?,?,?);";
    public static final String SELECT_ID_FROM_CATEGORY = "select id from category where category = ?; ";
    public static final String UPDATE_PRODUCT_SQL = "update products set name = ? , price =?, quantity = ? , color = ? where id = ?;";
    public static final String DELETE_PRODUCT_SQL = "delete from products where id = ?;";
    public static final String SELECT_ALL_FROM_PRODUCT = "select * from products ;";
    public static final String SELECT_PRODUCT_BYID = "select name,price, quantity,color from product where id =?";
    public static final String SELECT_PRODUCT_BYNAME = "select id,price, quantity,color where name = ? ";


    @Override
    public void saveNewProduct(String name, double price, int quantity, String color) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_PRODUCT);
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, quantity);
            statement.setString(4, color);


            statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateProduct(int id, String name, double price, int quantity, String color) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);

            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, quantity);
            statement.setString(4, color);
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Products> showAllProducts() {
        List<Products> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FROM_PRODUCT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");

                Products product = new Products(id, name, price, quantity, color);
                productList.add(product);

            }
            return productList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Products findProductByID(int id) {
        Products product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");

                product = new Products(id, name, price, quantity, color);
            }
            return product;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Products> findProductByName(String name) {
        List<Products> productsList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BYNAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                productsList.add(new Products(id, name, price, quantity, color));
            }
            return productsList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }


}