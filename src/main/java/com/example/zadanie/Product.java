package com.example.zadanie;

public class Product {
    private String name;
    private double prize;
    private Category category;

    public Product() {
    }

    public Product(String name, double prize) {
        this.name = name;
        this.prize = prize;
    }

    public Product(String name, double prize, Category category) {
        this.name = name;
        this.prize = prize;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
