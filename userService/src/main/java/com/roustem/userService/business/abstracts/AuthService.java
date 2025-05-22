package com.roustem.userService.business.abstracts;

import com.roustem.userService.entity.User;
import com.roustem.userService.entity.dto.UserAuthenticationResponseDto;
import com.roustem.userService.entity.dto.UserLoginRequestDto;
import com.roustem.userService.entity.dto.UserRegisterRequestDto;

public interface AuthService {

    UserAuthenticationResponseDto login(UserLoginRequestDto userLoginRequestDto);

}
