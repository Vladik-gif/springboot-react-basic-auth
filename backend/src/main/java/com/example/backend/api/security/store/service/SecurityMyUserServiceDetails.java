package com.example.backend.api.security.store.service;

import com.example.backend.api.security.store.entities.SecurityMyUserDetails;
import com.example.backend.store.entities.UserEntity;
import com.example.backend.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityMyUserServiceDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not frond" + username)
        );

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );

        return userDetails(user, authorities);
    }

    private SecurityMyUserDetails userDetails(UserEntity user,
                                              List<SimpleGrantedAuthority> authorities){
        return SecurityMyUserDetails
                .builder()
                .user(user)
                .authorities(authorities)
                .build();
    }
}
