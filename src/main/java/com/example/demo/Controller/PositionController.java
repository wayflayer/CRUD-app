package com.example.demo.Controller;

import com.example.demo.model.Position;
import com.example.demo.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    @GetMapping("/positions")
    public String positions(Model model) {
        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);
        return "position-list";
    }
    @GetMapping("/position-create")
    public String createPositionForm(Position position) {
        return "position-create";
    }
    @PostMapping("/position-create")
    public String createPosition(Position position) {
        positionService.savePosition(position);
        return "redirect:/positions";
    }
    @GetMapping("position-delete/{id}")
    public String deletePosition(@PathVariable("id") Long id) {
        positionService.deleteById(id);
        return "redirect:/positions";
    }
    @GetMapping("/position-update/{id}")
    public String updatePositionForm(@PathVariable("id") Long id, Model model) {
        Position position = positionService.findById(id);
        model.addAttribute("position", position);
        return "position-update";
    }
    @PostMapping("/position-update")
    public String updatePosition(Position position) {
        positionService.savePosition(position);
        return "redirect:/positions";
    }
}


