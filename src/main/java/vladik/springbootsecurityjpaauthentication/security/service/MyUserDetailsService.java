package vladik.springbootsecurityjpaauthentication.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vladik.springbootsecurityjpaauthentication.entity.UserEntity;
import vladik.springbootsecurityjpaauthentication.repository.UserRepository;
import vladik.springbootsecurityjpaauthentication.security.entity.MyUserDetailsEntity;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byUsername = userRepository.findByUsername(username);

        byUsername.orElseThrow(()-> new UsernameNotFoundException("User name not"));

        return byUsername.map(MyUserDetailsEntity::new).orElse(null);
    }
}
