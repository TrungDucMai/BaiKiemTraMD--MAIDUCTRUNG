package service.products;

import model.Products;

import java.util.List;

public interface IProductService {

    void saveNewProduct (String name, double price , int quantity, String color);
    void updateProduct (int id , String name, double price , int quantity, String color);
    void deleteProduct (int id);
    List<Products> showAllProducts();
    Products findProductByID (int id);
    List<Products> findProductByName (String name);
}
