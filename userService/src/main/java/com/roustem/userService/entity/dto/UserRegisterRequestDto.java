package com.roustem.userService.entity.dto;

import com.roustem.userService.entity.Claim;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequestDto {

    private String customerName;
    private String email;
    private String phone;
    private String password;
    private Claim claim;
}
