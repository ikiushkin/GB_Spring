package ru.grishenko.springboot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.grishenko.springboot.except.CreateProductException;
import ru.grishenko.springboot.services.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAllProducts(Model model,
                                 @RequestParam(required = false, name = "min_cost") Integer minCost,
                                 @RequestParam(required = false, name = "max_cost") Integer maxCost,
                                 @RequestParam(required = false, name = "error") String error
    ) {
        model.addAttribute("frontProducts", productService.getProducts(minCost, maxCost));
        model.addAttribute("frontErrors", error);

        return "index";
    }

    @PostMapping("/add")
    public String addNewProduct(@RequestParam(value = "") String title, @RequestParam(value = "") String cost) {
        String error = null;
        try {
            if (cost.equals("")) {
                cost = "0.00";
            }
            productService.addNewProduct(title, Float.parseFloat(cost));
        } catch (CreateProductException e) {
            error = e.getMessage();
        }
        if (error != null) {
            return "redirect:/products?error=" + error;
        } else {
            return "redirect:/products";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
