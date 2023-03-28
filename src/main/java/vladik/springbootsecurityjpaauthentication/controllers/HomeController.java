package vladik.springbootsecurityjpaauthentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    private static final String admin = "/admin";
    private static final String user = "/user";
    private static final String home = "/home";

    @GetMapping(home)
    public String getHome(){
        return "Home";
    }

    @GetMapping(user)
    public String getUser(){
        return "Hello, User";
    }

    @GetMapping(admin)
    public String getAdmin(){
        return "Hello, Admin";
    }
}
