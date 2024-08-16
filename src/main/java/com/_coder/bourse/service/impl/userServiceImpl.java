package com._coder.bourse.service.impl;

import com._coder.bourse.dto.UserDto;
import com._coder.bourse.exception.UserNotFoundException;
import com._coder.bourse.model.Confirmation;
import com._coder.bourse.model.User;
import com._coder.bourse.repository.ConfirmationRepository;
import com._coder.bourse.repository.UserRepository;
import com._coder.bourse.service.EmailService;
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
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;



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



    /**************************************email-----------------------*/
    @Override
    public Integer sendEmailUser(Integer id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("USER NOT FOUND with  ID : "+id));

        if (!userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email Not Found !");
        }
        else{
            user.setIsEnabled(false);

            Confirmation confirmation = new Confirmation(user);
            confirmationRepository.save(confirmation);

            /* TODO send email to user with token*/
            emailService.sendSimpleMailMessage(user.getFirstName(), user.getEmail(), confirmation.getToken());
            return id;

        }

    }

    @Override
    public Boolean existToken(String token) {

//FInd a confirmation
        Confirmation confirmation = confirmationRepository.findByToken(token);

//FInd a user
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());

//set activate user
        user.setIsEnabled(true);

//UPDATE a User
        userRepository.save(user);

        return Boolean.TRUE;
    }
}
