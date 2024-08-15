package com._coder.bourse.service.impl;

import com._coder.bourse.dto.CouncilDto;
import com._coder.bourse.exception.CommuneNotFoundException;
import com._coder.bourse.model.Council;
import com._coder.bourse.repository.CouncilRepository;
import com._coder.bourse.repository.UserRepository;
import com._coder.bourse.service.CouncilService;
import com._coder.bourse.util.CouncilUtil;
import com._coder.bourse.util.ImageUtil;
import com._coder.bourse.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouncilServiceImpl implements CouncilService {

    private final CouncilRepository councilRepository;
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
        return councilRepository.save(council).getId();
    }

    @Override
    public List<CouncilDto> findAll() {
        return councilRepository.findAll().stream().map(CouncilDto::fromDto).toList();
    }

    @Override
    public CouncilDto findById(Integer id) {
        return councilRepository
                .findById(id)
                .map(CouncilDto::fromDto)
                .orElseThrow(
                        ()-> new CommuneNotFoundException("COMMUNE NOT FOUND with ID : "+id)
                );

    }

    @Override
    public void delete(Integer id) {
        if(id == null) return;
        Optional<Council> council = councilRepository.findById(id);
        try{
            if(council.isPresent()){
                ImageUtil.deleteImageFile(council.get().getImagePath());
            }else{throw new EntityNotFoundException("PRODUCT NOT FOUND WITH ID: " + id);}

        }catch (IOException ioe){
            log.error("======================>>>>>>>>>:"+ioe.getMessage());
        }
        councilRepository.deleteById(id);

    }
}
