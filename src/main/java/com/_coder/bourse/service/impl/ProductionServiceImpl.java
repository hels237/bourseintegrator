package com._coder.bourse.service.impl;


import com._coder.bourse.dto.ProductionDto;
import com._coder.bourse.repository.ProductionRepository;
import com._coder.bourse.service.ProductionService;
import com._coder.bourse.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {

    private  final ProductionRepository productionRepository;
    private final ObjectValidator<ProductionDto> objectValidator;


    @Override
    public Integer save(ProductionDto productionDto) {
        //validation
        objectValidator.validate(productionDto);
        return productionRepository.save(ProductionDto.toEntity(productionDto)).getId();
    }

    @Override
    public List<ProductionDto> findAll() {
        return productionRepository.findAll().stream().map(ProductionDto::fromDto).toList();
    }

    @Override
    public ProductionDto findById(Integer id) {
        return productionRepository
                .findById(id)
                .map(ProductionDto::fromDto)
                .orElseThrow(()-> new EntityNotFoundException("PRODUCTION NOT FOUND WITH ID: " + id));
    }

    @Override
    public void delete(Integer id) {
        if (id == null) return;
        productionRepository.deleteById(id);
    }


}
