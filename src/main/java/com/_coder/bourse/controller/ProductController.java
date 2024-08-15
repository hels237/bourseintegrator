package com._coder.bourse.controller;

import com._coder.bourse.dto.ProductDto;
import com._coder.bourse.model.Product;
import com._coder.bourse.service.ProductService;
import com._coder.bourse.util.ProductUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryController categoryController;

    @PostMapping(value = "/",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createProduct(
            @RequestParam("designation") String productName,
            @RequestParam("price") BigDecimal price,
            @RequestParam("description") String description,
            @RequestParam("category") Integer categoryId,
            @RequestParam("production") Integer productionId,
            @RequestParam("image") MultipartFile imageProduct
    ) {

        productService.save(ProductUtil.productUtilDto(
                productName,price,description,
                categoryId,productionId,imageProduct
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(" PRODUCT SUCCESSFULLY CREATED !");
    }


    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("productId") Integer productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Integer productId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" PRODUCT SUCCESSFULLY DELETED !");
    }
}
