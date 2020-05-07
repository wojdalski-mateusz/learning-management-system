package pl.wojdalski.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojdalski.learningmanagementsystem.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
