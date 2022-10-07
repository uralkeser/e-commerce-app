package com.ecommerce.controller;

import com.ecommerce.dto.ClientRequestDTO;
import com.ecommerce.dto.ClientResponseDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("allCategories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PostMapping("{name}")
    public ResponseEntity<Category> saveCategory(@PathVariable String name ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(name));
    }

    @DeleteMapping("{name}")
    public ResponseEntity<String> deleteCategory(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.deleteCategoryByName(name));
    }
}
