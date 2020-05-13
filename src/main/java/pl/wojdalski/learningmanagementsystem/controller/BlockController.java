package pl.wojdalski.learningmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wojdalski.learningmanagementsystem.model.Block;
import pl.wojdalski.learningmanagementsystem.model.Lesson;
import pl.wojdalski.learningmanagementsystem.model.User;
import pl.wojdalski.learningmanagementsystem.repository.BlockRepository;
import pl.wojdalski.learningmanagementsystem.service.BlockServis;
import pl.wojdalski.learningmanagementsystem.service.LessonService;

import java.util.List;

@Controller
@RequestMapping(value = "/blok")
public class BlockController {

    private BlockRepository blockRepository;
    private BlockServis blockServis;
    private LessonService lessonService;

    public BlockController(BlockRepository blockRepository, BlockServis blockServis, LessonService lessonService) {
        this.blockRepository = blockRepository;
        this.blockServis = blockServis;
        this.lessonService = lessonService;
    }

    @GetMapping(value = "/lista")
    public String getAll(Model model) {
        List<Block> blocks = blockRepository.findAll();
        model.addAttribute("blocks", blocks);
        return "all-blocks";
    }

    @PostMapping(value = "/lista")
    public String addBlock(@ModelAttribute Block block) {

        blockServis.save(block);

        return "redirect:lista";
    }

    @GetMapping(value = "/dodaj")
    public String displayForm(Model model) {

        List<Lesson> lessonList = lessonService.findAll();
        model.addAttribute("block", new Block());
        model.addAttribute("lessonList", lessonList);
        return "addBlock";
    }

    @GetMapping(value = "/usun")
    public String deleteBlock(@RequestParam Long id) {
        blockServis.delete(id);
        return "redirect:lista";
    }

    @GetMapping(value = "/edytuj")
    public String editBlock(@RequestParam Long id,
                             Model model) {
        List<Lesson> lessonList = lessonService.findAll();
        model.addAttribute("block", blockServis.getBlock(id));
        model.addAttribute("lessonList", lessonList);
        return "addBlock";
    }
}
