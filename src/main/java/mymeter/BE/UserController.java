package mymeter.BE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    final
    UserService userService;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            userRepository.save(user);
            return "User successfully created";
        } else {
            return "Email already in use";
        }

    }

    @GetMapping("/users")
    public List<User> getUsers() { return userService.getUsers();}
}
