package com.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ExceptionMessages {
    ClientNotFoundException("Cannot found client by given info."),
    ExistentClientException("The client is already exist"),
    ProductNotFoundException("Cannot found product by given info."),
    CategoryNotFoundException("Cannot found category by given info."),
    ExistentCategoryException("The category is already exist");

    private String message;
}
