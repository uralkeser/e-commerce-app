package com.ecommerce.service;

import com.ecommerce.entity.Category;
import com.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final ValidationService validationService;

    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        log.info("requested all categories");
        return categoryList;
    }

    public Category saveCategory(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        validationService.validateNoneExistentCategory(category);
        Category newCategory = Category.builder()
                .name(name).build();
        categoryRepository.save(newCategory);
        log.info("saved category: " + newCategory.getName());
        return newCategory;
    }

    public String deleteCategoryByName(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        Category existingCategory = validationService.validateCategory(category);
        categoryRepository.deleteByName(name);
        log.info("deleted category: " + existingCategory.getName());
        return "Deletion is successful";
    }
}
