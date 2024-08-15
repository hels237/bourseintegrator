package com._coder.bourse.dto;

import com._coder.bourse.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UserDto {

    private Integer userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull @Email
    private String email;

    public static UserDto fromDto(User user){
        return UserDto
                .builder()
                .userId(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }


    public static User toEntity(UserDto userDto){
        return User
                .builder()
                .id(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

}
