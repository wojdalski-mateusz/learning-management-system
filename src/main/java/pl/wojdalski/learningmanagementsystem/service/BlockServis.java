package pl.wojdalski.learningmanagementsystem.service;

import org.springframework.stereotype.Service;
import pl.wojdalski.learningmanagementsystem.model.Block;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.repository.BlockRepository;

import java.util.List;

@Service
public class BlockServis {

    BlockRepository blockRepository;

    public BlockServis(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    public void save(Block block) {
        blockRepository.save(block);
    }

    public void delete(Long id) {
        blockRepository.deleteById(id);
    }

    public Block getBlock(Long id) {
        return blockRepository.getOne(id);
    }

}
