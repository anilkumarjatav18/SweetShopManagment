package com.sweetshop;


public class Sweet {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    public Sweet(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%s): %.2f x %d", id, name, category, price, quantity);
    }
}

