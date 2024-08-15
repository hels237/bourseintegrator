package com._coder.bourse.controller;

import com._coder.bourse.dto.CategoryDto;
import com._coder.bourse.service.CategoryService;
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

    @PostMapping("/")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(categoryDto)+" CATEGORY CREATED SUCCESSFULLY !");
    }


    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> findAllCategory() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" CATEGORY DELETED SUCCESSFULLY !");
    }
}
