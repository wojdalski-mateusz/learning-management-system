package pl.wojdalski.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojdalski.learningmanagementsystem.model.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {
}
