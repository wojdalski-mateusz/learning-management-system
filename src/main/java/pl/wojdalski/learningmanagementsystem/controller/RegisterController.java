package pl.wojdalski.learningmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.Course;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.UserRepository;
import pl.wojdalski.learningmanagementsystem.service.CourseService;
import pl.wojdalski.learningmanagementsystem.service.LessonService;
import pl.wojdalski.learningmanagementsystem.service.UserService;


import java.util.List;

@Controller
@RequestMapping(value = "/rejestracja")
public class RegisterController {

    private UserService userService;
    private CourseService courseService;


    public RegisterController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping(value = "")
    public String register(Model model) {

        List<Course> courseList = courseService.findAll();

        model.addAttribute("courseList", courseList);
        model.addAttribute("user", new User());

        return "register";
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
