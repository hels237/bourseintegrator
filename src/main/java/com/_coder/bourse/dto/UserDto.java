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

    private Integer id;
    private String username;
    private String password;

    public static UserDto fromDto(User user){
        return UserDto
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

    }


    public static User toEntity(UserDto userDto){
        return User
                .builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();

    }

}
