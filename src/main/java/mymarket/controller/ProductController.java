package mymarket.controller;

import lombok.RequiredArgsConstructor;
import mymarket.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import mymarket.exception_handling.ResourceNotFoundException;
import mymarket.repository.specification.ProductSpecifications;
import mymarket.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }

        return productService.findAll(ProductSpecifications.build(params), page, 5);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto saveProduct(@RequestBody ProductDto p) {
        p.setId(null);
        return productService.saveOrUpdate(p);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto p) {
        return productService.saveOrUpdate(p);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
