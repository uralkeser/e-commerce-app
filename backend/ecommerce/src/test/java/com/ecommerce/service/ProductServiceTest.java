package com.ecommerce.service;

import com.ecommerce.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void shouldGetAllProducts() {
    }

    @Test
    public void shouldSaveProduct() {
    }

    @Test
    public void shouldUpdateProduct() {
    }

    @Test
    public void shoulDeleteProductById() {
    }
}