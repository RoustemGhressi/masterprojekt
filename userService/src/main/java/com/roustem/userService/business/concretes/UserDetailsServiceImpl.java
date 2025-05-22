package com.roustem.userService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roustem.userService.business.abstracts.UserService;
import com.roustem.userService.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    System.out.println("Attempting to load user with email: " + email);
    User user = userService.getUserByEmail(email);

    if (user == null) {
        System.out.println("User not found for email: " + email);
        throw new UsernameNotFoundException("User not found");
    }

    System.out.println("User found: " + user.getEmail());
    System.out.println("Encoded password: " + user.getPassword());
    System.out.println("Authority: " + user.getClaim().getClaimName());

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(user.getClaim().getClaimName()));

    return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), authorities);
}
}
