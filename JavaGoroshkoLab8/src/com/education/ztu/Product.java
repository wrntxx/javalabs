package com.education.ztu;

public class Product {
    private String name;
    private String brand;
    private double price;
    private int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    public static double getTotalValue(Product product) {
        return product.getPrice() * product.getCount();
    }
    public static int compareByPrice(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", brand=" + brand + ", price=" + price + ", count=" + count + "]";
    }
}