package mymeter.BE.user;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public Optional<User> modifyUser(@RequestBody User newUser, @PathVariable String id) {
        return userService.modifyUser(newUser, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
         userService.deleteUser(id);
    }
}
