package com._coder.bourse.controller;

import com._coder.bourse.dto.CategoryDto;
import com._coder.bourse.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = " create a category")
    @PostMapping("/")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(categoryDto)+" CATEGORY CREATED SUCCESSFULLY !");
    }


    @Operation(summary = " get category by ID")
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    @Operation(summary = " get all category")
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> findAllCategory() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Operation(summary = " delete category by ID")
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" CATEGORY DELETED SUCCESSFULLY !");
    }
}
