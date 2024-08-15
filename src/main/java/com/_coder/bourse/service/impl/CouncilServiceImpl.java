package com._coder.bourse.service.impl;

import com._coder.bourse.dto.CouncilDto;
import com._coder.bourse.exception.CommuneNotFoundException;
import com._coder.bourse.model.Council;
import com._coder.bourse.repository.CommuneRepository;
import com._coder.bourse.repository.UserRepository;
import com._coder.bourse.service.CouncilService;
import com._coder.bourse.util.CouncilUtil;
import com._coder.bourse.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouncilServiceImpl implements CouncilService {

    private final CommuneRepository communeRepository;
    private final ObjectValidator<CouncilDto> objectValidator;
    private final UserRepository userRepository;

    @Override
    public Integer save(CouncilDto councilDto) {
        //validation
        objectValidator.validate(councilDto);

        Council council = new Council();
        try{
            council = CouncilUtil.councilUtil(councilDto, councilDto.getImageCouncil());
        }catch (IOException exc){
            log.error("=========================>>>>>>>:"+exc.getMessage());
        }
        return communeRepository.save(council).getId();
    }

    @Override
    public List<CouncilDto> findAll() {
        return communeRepository.findAll().stream().map(CouncilDto::fromDto).toList();
    }

    @Override
    public CouncilDto findById(Integer id) {
        return communeRepository
                .findById(id)
                .map(CouncilDto::fromDto)
                .orElseThrow(
                        ()-> new CommuneNotFoundException("COMMUNE NOT FOUND with ID : "+id)
                );

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
                return;
        }
        communeRepository.deleteById(id);
    }

    @Override
    public Page<Council> searchCouncilsByProduct(String productName, String productDesignation, Pageable pageable){
        return communeRepository.findCouncilsByProductionAttributes(productName, productDesignation, pageable);
    }
}
