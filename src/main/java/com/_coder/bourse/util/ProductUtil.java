package com._coder.bourse.util;

import com._coder.bourse.dto.ProductDto;
import com._coder.bourse.model.Category;
import com._coder.bourse.model.Product;
import com._coder.bourse.model.Production;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

@NoArgsConstructor
public class ProductUtil {

    public  static ProductDto productUtilDto(
            String productName,
            BigDecimal price,
            String description,
            Integer categoryId,
            Integer productionId,
            MultipartFile productImage)  {


        return ProductDto
                .builder()
                .designation(productName)
                .price(price)
                .description(description)
                .categoryId(categoryId)
                .productionId(productionId)
                .imageProduct(productImage)
                .build();

    }

    public static Product productUtilEntity(ProductDto dto, MultipartFile productImage) throws IOException {
        String imagePath0 = ImageUtil.saveImage(productImage,"product-image" );

        Production productionEntity = new Production();
        Category categoryEntity = new Category();
        productionEntity.setId(dto.getProductionId());
        categoryEntity.setId(dto.getCategoryId());

        Product product = new Product();
        product.setDesignation(dto.getDesignation());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setProduction(productionEntity);
        product.setCategory(categoryEntity);
        product.setImagePath(imagePath0);
        return product;
    }
}
