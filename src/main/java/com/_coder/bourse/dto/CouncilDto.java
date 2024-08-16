package com._coder.bourse.dto;


import com._coder.bourse.model.Council;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class CouncilDto {

    private Integer id;

    @NotNull
    private String councilName;

    @NotNull
    private String mayorName;

    @NotNull
    private String country;

    @Email @NotNull
    private String email;

    private Long population;
    private BigDecimal area;
    private String region;
    private  MultipartFile imageCouncil;
    private String imagePath;
    private String postalCode;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String matriculeCommunale;

    private List<ProductDto> productDtos;


    public static CouncilDto fromDto(Council council) {

        return CouncilDto
                .builder()
                .id(council.getId())
                .councilName(council.getCouncilName())
                .email(council.getEmail())
                .country(council.getCountry())
                .mayorName(council.getMayorName())
                .population(council.getPopulation())
                .area(council.getArea())
                .region(council.getRegion())
                .imagePath(council.getImagePath())
                .postalCode(council.getPostalCode())
                .longitude(council.getLongitude())
                .latitude(council.getLatitude())
                .productDtos(council.getProducts().stream().map(ProductDto::fromDto).toList())
                .build();
    }

    public static Council toEntity(CouncilDto councilDto) throws IOException {
        //String imagePath0 = ImageUtil.saveImage(imageCouncil,"council-image" );
        return Council
                .builder()
                .councilName(councilDto.getCouncilName())
                .country(councilDto.getCountry())
                .email(councilDto.getEmail())
                .population(councilDto.getPopulation())
                .area(councilDto.getArea())
                .region(councilDto.getRegion())
                .mayorName(councilDto.getMayorName())
                .build();
    }
}
