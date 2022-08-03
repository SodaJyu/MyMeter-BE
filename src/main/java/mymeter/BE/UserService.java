package mymeter.BE;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User modifyUser(User newUser, String id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirst_name(newUser.getFirst_name());
                    user.setLast_name(newUser.getLast_name());
                    user.setEmail(newUser.getEmail());
                    user.setCity(newUser.getCity());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    return userRepository.save(newUser);
                });
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
