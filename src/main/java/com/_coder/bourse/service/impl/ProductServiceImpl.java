package com._coder.bourse.service.impl;

import com._coder.bourse.dto.ProductDto;
import com._coder.bourse.model.Council;
import com._coder.bourse.model.Product;
import com._coder.bourse.repository.CommuneRepository;
import com._coder.bourse.repository.ProductRepository;
import com._coder.bourse.service.ProductService;
import com._coder.bourse.util.CouncilUtil;
import com._coder.bourse.util.ProductUtil;
import com._coder.bourse.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CommuneRepository communeRepository;
    private final ObjectValidator<ProductDto> objectValidator;


    @Override
    public Integer save(ProductDto productDto) {
        objectValidator.validate(productDto);
        //validation
        Product product = new Product();

        try{
            product = ProductUtil.productUtilEntity(productDto, productDto.getImage());
        }catch (IOException exc){
            log.error("=========================>>>>>>>:"+exc.getMessage());
        }
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductDto::fromDto).toList();
    }

    @Override
    public ProductDto findById(Integer id) {
        return productRepository
                .findById(id)
                .map(ProductDto::fromDto)
                .orElseThrow(
                        ()-> new EntityNotFoundException("PRODUCT NOT FOUND WITH ID: " + id)
                );
    }

    @Override
    public void delete(Integer id) {
        if(id == null) return;
        productRepository.deleteById(id);
    }
}
