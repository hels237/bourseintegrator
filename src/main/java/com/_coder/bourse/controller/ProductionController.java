package com._coder.bourse.controller;

import com._coder.bourse.dto.ProductionDto;
import com._coder.bourse.service.ProductionService;
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

    @PostMapping("/")
    public ResponseEntity<String> createProduction(@RequestBody ProductionDto productionDto) {
        System.out.println("controller" + productionDto);
        productionService.save(productionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("PRODUCTION CREATED SUCCESSFULLY");

    }

    @GetMapping("/{productionId}")
    public  ResponseEntity<ProductionDto> findProductionById(@PathVariable("productionId") Integer id) {
        return ResponseEntity.ok(productionService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductionDto>> findAllProduction() {
        return ResponseEntity.ok(productionService.findAll());
    }

    @DeleteMapping("/{productionId}")
    public ResponseEntity<String> deleteProductionById(@PathVariable("productionId") Integer id) {
        productionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("PRODUCTION DELETED SUCCESSFULLY");
    }
}
