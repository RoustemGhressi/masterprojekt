package com.roustem.userService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.roustem.userService.business.abstracts.UserService;
import com.roustem.userService.entity.dto.UserRegisterRequestDto;

@RestController
@RequestMapping("/api/user/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("isExist/{userId}")
    public boolean isExists(@PathVariable String userId) {
        return userService.isUserExist(userId);
    }


    @PostMapping("add")
    public String addUser(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        userService.addUser(userRegisterRequestDto);
        return "redirect:/login.html";
    }

    @GetMapping("isUserCustomer")
    public boolean isUserCustomer() {
        return userService.isUserCustomer();
    }
    @GetMapping("isUserAdmin")
    public boolean isUserAdmin() {
        return userService.isUserAdmin();
    }
}