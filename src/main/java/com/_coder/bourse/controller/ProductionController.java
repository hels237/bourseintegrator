package com._coder.bourse.controller;

import com._coder.bourse.dto.ProductionDto;
import com._coder.bourse.service.ProductionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production")
@RequiredArgsConstructor
public class ProductionController {

    private final ProductionService productionService;


    @Operation(summary = " create a production")
    @PostMapping("/")
    public ResponseEntity<String> createProduction(@RequestBody ProductionDto productionDto) {
        System.out.println("controller" + productionDto);
        productionService.save(productionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("PRODUCTION CREATED SUCCESSFULLY");

    }

    @Operation(summary = " get product by ID")
    @GetMapping("/{productionId}")
    public  ResponseEntity<ProductionDto> findProductionById(@PathVariable("productionId") Integer id) {
        return ResponseEntity.ok(productionService.findById(id));
    }

    @Operation(summary = " get all products")
    @GetMapping("/")
    public ResponseEntity<List<ProductionDto>> findAllProduction() {
        return ResponseEntity.ok(productionService.findAll());
    }

    @Operation(summary = " delete product by ID")
    @DeleteMapping("/{productionId}")
    public ResponseEntity<String> deleteProductionById(@PathVariable("productionId") Integer id) {
        productionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("PRODUCTION DELETED SUCCESSFULLY");
    }
}
