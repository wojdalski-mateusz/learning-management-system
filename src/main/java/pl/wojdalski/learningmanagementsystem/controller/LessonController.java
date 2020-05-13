package pl.wojdalski.learningmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.LessonRepository;
import pl.wojdalski.learningmanagementsystem.service.LessonService;
import pl.wojdalski.learningmanagementsystem.service.UserService;

import java.util.List;


@Controller
@RequestMapping(value = "/zajecia")
public class LessonController {

    private LessonRepository lessonRepository;
    private LessonService lessonService;
    private UserService userService;

    public LessonController(LessonRepository lessonRepository, LessonService lessonService, UserService userService) {
        this.lessonRepository = lessonRepository;
        this.lessonService = lessonService;
        this.userService = userService;
    }

    @GetMapping(value = "/lista")
    public String getAll(Model model) {
        List<Lesson> lessons = lessonRepository.findAll();
        model.addAttribute("lessons", lessons);
        return "all-lessons";
    }

    @PostMapping(value = "/lista")
    public String addLesson(@ModelAttribute Lesson lesson) {

        lessonService.save(lesson);

        return "redirect:lista";
    }

    @GetMapping(value = "/dodaj")
    public String displayForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "addLesson";
    }

    @GetMapping(value = "/usun")
    public String deleteLesson(@RequestParam Long id) {
        lessonService.delete(id);
        return "redirect:lista";
    }

    @GetMapping(value = "/edytuj")
    public String editLesson(@RequestParam Long id,
                           Model model) {
        model.addAttribute("lesson", lessonService.getLesson(id));
        return "addLesson";
    }
}
