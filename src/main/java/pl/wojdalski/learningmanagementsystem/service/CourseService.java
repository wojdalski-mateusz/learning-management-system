package pl.wojdalski.learningmanagementsystem.service;

import org.springframework.stereotype.Service;
import pl.wojdalski.learningmanagementsystem.model.Block;
import pl.wojdalski.learningmanagementsystem.model.Course;
import pl.wojdalski.learningmanagementsystem.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course getCourse(Long id) {
        return courseRepository.getOne(id);
    }
}
