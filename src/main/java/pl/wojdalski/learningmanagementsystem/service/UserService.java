package pl.wojdalski.learningmanagementsystem.service;

import org.springframework.stereotype.Service;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
