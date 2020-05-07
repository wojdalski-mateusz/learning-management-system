package pl.wojdalski.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojdalski.learningmanagementsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
