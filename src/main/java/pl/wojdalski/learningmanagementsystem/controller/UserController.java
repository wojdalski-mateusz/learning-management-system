package pl.wojdalski.learningmanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.Course;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;
import pl.wojdalski.learningmanagementsystem.service.CourseService;
import pl.wojdalski.learningmanagementsystem.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/uzytkownik")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;
    private CourseService courseService;

    public UserController(UserRepository userRepository, UserService userService, CourseService courseService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping(value = "")
    public String dashboard() {

        return "user/dashboard";
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
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        model.addAttribute("user", userService.getUser(id));
        return "addUser";
    }
}
