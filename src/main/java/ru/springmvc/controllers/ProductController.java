package ru.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.springmvc.exceptions.CreateProductException;
import ru.springmvc.models.ErrorModel;
import ru.springmvc.models.Product;
import ru.springmvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController{

    private ProductService productService;
    private boolean fromAddPage;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        if (!fromAddPage) {
            listError.clear();
        }
        model.addAttribute("frontProducts", productService.getProducts());
        model.addAttribute("frontErrors", listError);
        fromAddPage = false;
        return "index";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product, BindingResult result) {
        listError.clear();
        if (!result.hasErrors()) {
            try {                                           // пробуем создать продукт, репозиторий проверяет правильность данных
                productService.addNewProduct(product);
            } catch (CreateProductException e) {            // если с данными продукта что-то не так
                listError.add(new ErrorModel("Product", e.getField(), e.getMessage()));
            }
        } else {
            FieldError fieldError;
            for (ObjectError or : result.getAllErrors()) {
                if (or instanceof FieldError) {
                    fieldError = (FieldError) or;
                    listError.add(new ErrorModel(fieldError, "Поле " + fieldError.getField() + " заполнено не верно."));
                }
            }
        }

        fromAddPage = true;
        return "redirect:/products/all";
    }

}
