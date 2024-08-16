package com._coder.bourse.service;

import com._coder.bourse.dto.UserDto;
import com._coder.bourse.model.User;

public interface UserService extends AbstractService<UserDto> {
    Integer sendEmailUser(Integer id);
    Boolean existToken(String token);
}
