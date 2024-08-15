package com._coder.bourse.dto;


import com._coder.bourse.model.Production;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class ProductionDto {

    private Integer productionId;

    private Integer qte;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    private Integer councilId;

    private List<ProductDto> productDto;

    private CouncilDto councilDto;

    public static ProductionDto fromDto(Production production) {
        return ProductionDto
                .builder()
                .productionId(production.getId())
                .qte(production.getQte())
                .productDto(production.getProducts().stream().map(ProductDto::fromDto).toList())
                .dateDebut(production.getDateDebut())
                .dateFin(production.getDateFin())
                .councilDto(CouncilDto.fromDto(production.getCouncil()))
                .build();
    }

    public static Production toEntity(Production production ){
        return Production
                .builder()
                .qte(production.getQte())
                .dateFin(production.getDateFin())
                .dateDebut(production.getDateDebut())
                .build();
    }
}
