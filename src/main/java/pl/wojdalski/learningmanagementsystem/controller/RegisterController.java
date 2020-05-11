package pl.wojdalski.learningmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;
import pl.wojdalski.learningmanagementsystem.service.UserService;


import java.util.List;

@Controller
@RequestMapping(value = "/rejestracja")
public class RegisterController {

    private UserService userService;
    private UserRepository userRepository;

    public RegisterController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "")
    public String register(Model model) {

        List<User> userList = userService.findAll();

        model.addAttribute("userList", userList);
        model.addAttribute("user", new User());

        return "register";
    }

    @GetMapping(value = "/lista")
    public String getAll(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "all-users";
    }

    @PostMapping(value = "/podsumowanie")
    public String summaryRegister(@ModelAttribute User user,
                                  Model model) {

            List<User> userList = userService.findAll();
            model.addAttribute("userList", userList);

        model.addAttribute("user", user);
        userService.save(user);

        return "summary";
    }
}
