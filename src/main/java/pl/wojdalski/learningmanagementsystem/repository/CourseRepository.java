package pl.wojdalski.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wojdalski.learningmanagementsystem.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
