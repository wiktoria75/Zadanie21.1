package com.example.zadanie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("categories", Category.values());
        return "index.html";
    }

    @GetMapping("/lista")
    public String home(Model model, @RequestParam(name = "kategoria", required = false) String plName) {
        Set<Product> selectedProducts;
        String categoryName;
        if (plName == null) {
            selectedProducts = productRepository.getProductSet();
            categoryName = "Wszystkie";
        } else {
            Category category = Category.findByPlName(plName);
            selectedProducts = productRepository.filterByCategory(category);
            categoryName = category.getDescription();
        }
        model.addAttribute("sum", productRepository.calculateSum(selectedProducts));
        model.addAttribute("productList", selectedProducts);
        model.addAttribute("categoryDescription", categoryName);
        return "lista.html";
    }

    @RequestMapping("/formularz")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", Category.values());
        return "formularz.html";
    }

    @RequestMapping("/save")
    public String add(Product product) {
        productRepository.add(product);
        return "redirect:/lista";
    }
}
