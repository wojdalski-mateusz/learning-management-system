package pl.wojdalski.learningmanagementsystem.service;

import org.springframework.stereotype.Service;
import pl.wojdalski.learningmanagementsystem.model.Role;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.RoleRepository;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

}
