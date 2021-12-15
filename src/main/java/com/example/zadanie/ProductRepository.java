package com.example.zadanie;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private Set<Product> productSet;

    public ProductRepository() {
        productSet = new HashSet<>();
        productSet.add(new Product("pomidor", 0.59, Category.FOOD));
        productSet.add(new Product("cebula", 0.19, Category.FOOD));
        productSet.add(new Product("poduszka", 49.99, Category.HOUSEHOLD_ITEMS));
        productSet.add(new Product("wiertarka", 119.99, Category.HOUSEHOLD_ITEMS));
        productSet.add(new Product("rzutnik", 359.50, Category.OTHER));
        productSet.add(new Product("łódź podwodna", 12_000, Category.OTHER));
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public Set<Product> filterByCategory(Category category) {
        return productSet.stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toSet());
    }

    public void add(Product product) {
        productSet.add(product);
    }

    public double calculateSum(Set<Product> products) {
        return products.stream()
                .map(Product::getPrize)
                .reduce(0.00, Double::sum);
    }
}
