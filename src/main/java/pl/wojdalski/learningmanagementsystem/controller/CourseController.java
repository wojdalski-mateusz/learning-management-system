package pl.wojdalski.learningmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.Block;
import pl.wojdalski.learningmanagementsystem.model.Course;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.repository.CourseRepository;
import pl.wojdalski.learningmanagementsystem.service.BlockServis;
import pl.wojdalski.learningmanagementsystem.service.CourseService;

import java.util.List;

@Controller
@RequestMapping(value = "/kurs")
public class CourseController {

    private CourseRepository courseRepository;
    private CourseService courseService;
    private BlockServis blockServis;

    public CourseController(CourseRepository courseRepository, CourseService courseService, BlockServis blockServis) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
        this.blockServis = blockServis;
    }

    @GetMapping(value = "/lista")
    public String getAll(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "all-courses";
    }

    @PostMapping(value = "/lista")
    public String addCourse(@ModelAttribute Course course) {

        courseService.save(course);

        return "redirect:lista";
    }

    @GetMapping(value = "/dodaj")
    public String displayForm(Model model) {

        List<Block> blockList = blockServis.findAll();
        model.addAttribute("course", new Course());
        model.addAttribute("blockList", blockList);
        return "addCourse";
    }

    @GetMapping(value = "/usun")
    public String deleteCourse(@RequestParam Long id) {
        courseService.delete(id);
        return "redirect:lista";
    }

    @GetMapping(value = "/edytuj")
    public String editCourse(@RequestParam Long id,
                            Model model) {
        List<Block> blockList = blockServis.findAll();
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("blockList", blockList);
        return "addCourse";
    }
}

