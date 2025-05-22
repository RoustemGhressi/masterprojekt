package com.roustem.userService.business.abstracts;

import com.roustem.userService.entity.User;
import com.roustem.userService.entity.dto.UserRegisterRequestDto;

public interface UserService {

    Boolean isUserExist(String userId);

    void addUser(UserRegisterRequestDto userRegisterRequestDto);

    User getUserByEmail(String email);

    boolean isUserCustomer();

    boolean isUserAdmin();
}
