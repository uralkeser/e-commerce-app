package com.ecommerce.converter;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "vendorClient.id", source = "vendorUserId")
    Product convertProductDTOToProduct(ProductDTO productDTO);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "vendorClient.id", target = "vendorUserId")
    ProductDTO convertProductToProductDTO(Product product);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "vendorClient.id", target = "vendorUserId")
    List<ProductDTO> convertProductListToProductDTOList(List<Product> productList);

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "vendorClient.id", source = "vendorUserId")
    List<Product> convertProductDTOListToProductList(List<ProductDTO> productDTOList);
}