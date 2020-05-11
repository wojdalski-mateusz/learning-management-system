package pl.wojdalski.learningmanagementsystem.service;

import org.springframework.stereotype.Service;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.LessonRepository;

import java.util.List;

@Service
public class LessonService {

    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }

    public Lesson getLesson(Long id) {
        return lessonRepository.getOne(id);
    }
}
