package com._coder.bourse.service.impl;

import com._coder.bourse.dto.UserDto;
import com._coder.bourse.exception.UserNotFoundException;
import com._coder.bourse.model.User;
import com._coder.bourse.repository.UserRepository;
import com._coder.bourse.service.UserService;
import com._coder.bourse.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectValidator<UserDto> objectValidator;


    @Override
    public Integer save(UserDto userDto) {
        objectValidator.validate(userDto);
        return userRepository.save(UserDto.toEntity(userDto)).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromDto).toList();
    }

    @Override
    public UserDto findById(Integer id) {
        return userRepository
                .findById(id)
                .map(UserDto::fromDto)
                .orElseThrow(
                        ()-> new UserNotFoundException("USER NOT FOUND with  ID : "+id)
                );
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }
       userRepository.deleteById(id);
    }
}
