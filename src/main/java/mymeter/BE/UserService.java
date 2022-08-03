package mymeter.BE;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() { return userRepository.findAll();}
}
