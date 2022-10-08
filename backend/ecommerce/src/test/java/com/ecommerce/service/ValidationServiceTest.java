package com.ecommerce.service;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceTest {

    @InjectMocks
    private ValidationService validationService;
    Client client;
    Category category;
    Product product;
    Optional<Client> optionalClient;
    Optional<Client> optionalClient2;
    Optional<Product> optionalProduct;
    Optional<Product> optionalProduct2;
    Optional<Category> optionalCategory;
    Optional<Category> optionalCategory2;

    @Before
    public void setup(){
        client = Client.builder()
                .id(1L)
                .fullName("TEST")
                .userName("test")
                .password("test")
                .mail("test")
                .mobileNumber("test")
                .build();

        category = Category.builder()
                    .id(1L)
                    .name("test")
                    .build();

        product = Product.builder()
                .id(1L)
                .name("TEST")
                .discount(1L)
                .imageUrl("test")
                .price(1L)
                .category(category)
                .vendorClient(client)
                .build();

        optionalClient = Optional.of(client);

        optionalClient2 = Optional.empty();

        optionalProduct = Optional.of(product);

        optionalProduct2 = Optional.empty();

        optionalCategory = Optional.of(category);

        optionalCategory2 = Optional.empty();

    }

    @Test
    public void shouldValidateClient() {

        assertEquals(validationService.validateClient(optionalClient),client);

        try{
            validationService.validateClient(optionalClient2);
            fail();
        } catch (ClientNotFoundException ex){
            assertEquals("Cannot found client by given info.",ex.getMessage());
        }
    }

    @Test
    public void shouldValidateNoneExistentClient() {
        try{
            validationService.validateNoneExistentClient(optionalClient);
            fail();
        } catch (ExistentClientException ex){
            assertEquals("The client is already exist",ex.getMessage());
        }
    }

    @Test
    public void shouldValidateProduct() {
        assertEquals(validationService.validateProduct(optionalProduct),product);

        try{
            validationService.validateProduct(optionalProduct2);
            fail();
        } catch (ProductNotFoundException ex){
            assertEquals("Cannot found product by given info.",ex.getMessage());
        }

    }

    @Test
    public void shouldValidateCategory() {
        assertEquals(validationService.validateCategory(optionalCategory),category);

        try{
            validationService.validateCategory(optionalCategory2);
            fail();
        } catch (CategoryNotFoundException ex){
            assertEquals("Cannot found category by given info.",ex.getMessage());
        }
    }

    @Test
    public void shouldValidateNoneExistentCategory() {
        try{
            validationService.validateNoneExistentCategory(optionalCategory);
            fail();
        } catch (ExistentCategoryException ex){
            assertEquals("The category is already exist",ex.getMessage());
        }
    }
}