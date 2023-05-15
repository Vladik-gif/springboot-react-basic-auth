package vladik.springbootsecurityjpaauthentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vladik.springbootsecurityjpaauthentication.entity.UserEntity;
import vladik.springbootsecurityjpaauthentication.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final UserRepository userRepository;

    public ClientController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/clients")
    public List<UserEntity> gets(){
        return userRepository.findAll();
    }
}
