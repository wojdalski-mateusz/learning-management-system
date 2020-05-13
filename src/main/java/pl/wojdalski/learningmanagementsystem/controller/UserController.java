package pl.wojdalski.learningmanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;
import pl.wojdalski.learningmanagementsystem.service.LessonService;
import pl.wojdalski.learningmanagementsystem.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/uzytkownik")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;
    private LessonService lessonService;

    public UserController(UserRepository userRepository, UserService userService, LessonService lessonService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.lessonService = lessonService;
    }

    @GetMapping(value = "/lista")
    public String getAll(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "all-users";
    }

    @PostMapping(value = "/lista")
    public String addUser(@ModelAttribute User user) {

        userService.save(user);

        return "redirect:lista";
    }

    @GetMapping(value = "/dodaj")
    public String displayForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping(value = "/usun")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:lista";
    }

    @GetMapping(value = "/edytuj")
    public String editUser(@RequestParam Long id,
                           Model model) {
        List<Lesson> lessonList = lessonService.findAll();
        model.addAttribute("lessonList", lessonList);
        model.addAttribute("user", userService.getUser(id));
        return "addUser";
    }
}
