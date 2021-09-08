package model;

public class Products {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;


    public Products() {
    }

    public Products(String name, double price, int quantity, String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Products(int id, String name, double price, int quantity, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
