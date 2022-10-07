package com.ecommerce.service;

import com.ecommerce.converter.ProductConverter;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;
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
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ValidationService validationService;
    
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = ProductConverter.INSTANCE.convertProductListToProductDTOList(productList);
        log.info("requested all products");
        return productDTOList;
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product newProduct = ProductConverter.INSTANCE.convertProductDTOToProduct(productDTO);
        newProduct = productRepository.save(newProduct);
        ProductDTO savedProductDTO = ProductConverter.INSTANCE.convertProductToProductDTO(newProduct);
        log.info("saved product: " + newProduct.getName());
        return savedProductDTO;
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(id);
        Product existingProduct = validationService.validateProduct(product);

        //validate category
        Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());
        Category existingCategory = validationService.validateCategory(category);

        existingProduct.setName(productDTO.getName());
        existingProduct.setDiscount(productDTO.getDiscount());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setImageUrl(productDTO.getImageUrl());
        existingProduct.setCategory(existingCategory);

        productDTO = ProductConverter.INSTANCE.convertProductToProductDTO(productRepository.save(existingProduct));
        log.info("updated product: " + productDTO.getName());
        return productDTO;
    }

    public String deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        Product existingProduct = validationService.validateProduct(product);
        productRepository.deleteById(id);
        log.info("deleted product: " + existingProduct.getName());
        return "Deletion is successful";
    }
}
