package com._coder.bourse.util;

import com._coder.bourse.dto.ProductDto;
import com._coder.bourse.dto.ProductionDto;
import com._coder.bourse.model.Production;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProductionUtil {

    public static Production productionEntityUtil(ProductionDto dto){
        System.out.println("=================================>>>>>>dto"+dto.toString());
        Production production = new Production();
        production.getCouncil().setId(dto.getCouncilId());
        production.setQte(dto.getQte());
        production.setDateDebut(dto.getDateDebut());
        production.setDateFin(dto.getDateFin());
        return production;

    }
}
