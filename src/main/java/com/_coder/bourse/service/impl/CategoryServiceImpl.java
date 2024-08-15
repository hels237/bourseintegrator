package com._coder.bourse.service.impl;

import com._coder.bourse.dto.CategoryDto;
import com._coder.bourse.repository.CategoryRepository;
import com._coder.bourse.service.CategoryService;
import com._coder.bourse.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ObjectValidator<CategoryDto> objectValidator;



    @Override
    public Integer save(CategoryDto categoryDto) {
        objectValidator.validate(categoryDto);
        return categoryRepository.save(CategoryDto.toEntity(categoryDto)).getId();
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromDto).toList();
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryRepository
                .findById(id)
                .map(CategoryDto::fromDto)
                .orElseThrow(()-> new EntityNotFoundException("CATEGORY NOT FOUND WITH ID : "+id));
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            return;
        }
        categoryRepository.deleteById(id);
    }
}
