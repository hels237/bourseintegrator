package com._coder.bourse.dto;

import com._coder.bourse.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CategoryDto {

    private Integer categoryId;
    @NotNull
    private String categoryName;

    private String description;

    public static CategoryDto fromDto(Category category) {
        return CategoryDto
                .builder()
                .categoryId(category.getId())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        return Category
                .builder()
                .categoryName(categoryDto.getCategoryName())
                .description(categoryDto.getDescription())
                .build();
    }

}
