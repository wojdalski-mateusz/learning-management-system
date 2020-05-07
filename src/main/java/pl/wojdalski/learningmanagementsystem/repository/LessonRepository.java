package pl.wojdalski.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojdalski.learningmanagementsystem.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
