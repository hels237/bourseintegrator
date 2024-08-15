package com._coder.bourse.dto;

import com._coder.bourse.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
public class ProductDto {

    private Integer id;
    @NotNull
    private String designation;

    private String status;
   @NotNull
    private BigDecimal price;

   @NotNull
    private String description;

    private Integer categoryId;

    private Integer productionId;

    private CategoryDto categoryDto;

    private ProductionDto productionDto;

    private String image;



    public static ProductDto fromDto(Product product) {
        return ProductDto
                .builder()
                .id(product.getId())
                .designation(product.getDesignation())
                .status(product.getStatus())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryDto(CategoryDto.fromDto(product.getCategory()))
                .productionDto(ProductionDto.fromDto(product.getProduction()))
                .image(product.getImagePath())
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        return Product
                .builder()
                .designation(productDto.getDesignation())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(CategoryDto.toEntity(productDto.getCategoryDto()))
                .build();
    }
}
