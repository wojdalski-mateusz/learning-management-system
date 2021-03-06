package pl.wojdalski.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojdalski.learningmanagementsystem.model.Role;
import pl.wojdalski.learningmanagementsystem.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByRole(Role role);

}
