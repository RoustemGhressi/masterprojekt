package com.roustem.userService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roustem.userService.business.abstracts.ClaimService;
import com.roustem.userService.business.abstracts.UserService;
import com.roustem.userService.dao.UserDao;
import com.roustem.userService.entity.Claim;
import com.roustem.userService.entity.User;
import com.roustem.userService.entity.dto.UserRegisterRequestDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ClaimService claimService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean isUserExist(String userId) {

        User user = userDao.findUserByUserId(userId);

        if (user == null) {
            return false;
        }

        return true;
    }

    @Override
    public void addUser(UserRegisterRequestDto userRegisterRequestDto) {

        
        
        User user = User.builder()
                        .email(userRegisterRequestDto.getEmail())
                        .password(passwordEncoder.encode(userRegisterRequestDto.getPassword()))
                        .fullName(userRegisterRequestDto.getCustomerName())
                        .claim(userRegisterRequestDto.getClaim())
                        .build();
                        
        System.out.println("User before saving: " + user);
        userDao.insert(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public boolean isUserCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().allMatch(
                a -> a.getAuthority().equals("ROLE_CUSTOMER")
        )) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(
                a -> a.getAuthority().equals("ROLE_ADMIN")
        )) {
            return true;
        }
        return false;
    }
}
