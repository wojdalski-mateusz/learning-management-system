package pl.wojdalski.learningmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;
import pl.wojdalski.learningmanagementsystem.service.UserService;

@Controller
@RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
public class RegisterController {

    private UserService userService;

    public RegisterController (UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String register(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

}
