package com.ecommerce.service;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.*;
import com.ecommerce.entity.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ValidationService {

    public Client validateClient(Optional<Client> client){
        if(client.isPresent()){
            return client.get();
        }
        else {
            throw new ClientNotFoundException(ExceptionMessages.ClientNotFoundException.getMessage());
        }
    }

    public void validateNoneExistentClient(Optional<Client> client){
        if(client.isPresent()){
            throw new ExistentClientException(ExceptionMessages.ExistentClientException.getMessage());
        }
    }

    public Product validateProduct(Optional<Product> product){
        if(product.isPresent()){
            return product.get();
        }
        else {
            throw new ProductNotFoundException(ExceptionMessages.ProductNotFoundException.getMessage());
        }
    }

    public Category validateCategory(Optional<Category> category){
        if(category.isPresent()){
            return category.get();
        }
        else {
            throw new CategoryNotFoundException(ExceptionMessages.CategoryNotFoundException.getMessage());
        }
    }

    public void validateNoneExistentCategory(Optional<Category> category){
        if(category.isPresent()){
            throw new ExistentCategoryException(ExceptionMessages.ExistentCategoryException.getMessage());
        }
    }


}
