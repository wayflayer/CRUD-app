package com.example.demo.Controller;

import com.example.demo.model.Allow;
import com.example.demo.Service.AllowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AllowController {
    private final AllowService allowService;
    @Autowired
    public AllowController(AllowService allowService) {
        this.allowService = allowService;
    }
    @GetMapping("/allows")
    public String allows(Model model) {
        List<Allow> allows = allowService.findAll();
        model.addAttribute("allows", allows);
        return "allow-list";
    }
    @GetMapping("/allow-create")
    public String allowCreateForm(Model model) {
        return "allow-create";
    }
    @PostMapping("/allow-create")
    public String allowCreate(Allow allow) {
        allowService.saveAllow(allow);
        return "redirect:/allows";
    }
    @GetMapping("allow-delete/{id}")
    public String deleteAllow(@PathVariable("id") Long id) {
        allowService.deletebyId(id);
        return "redirect:/allows";
    }
    @GetMapping("/allow-update/{id}")
    public String updateAllowForm(@PathVariable("id") Long id, Model model) {
        Allow allow = allowService.findById(id);
        model.addAttribute("allow", allow);
        return "allow-update";
    }
    @PostMapping("/allow-update")
    public String updateAllow(Allow allow) {
        allowService.saveAllow(allow);
        return "redirect:/allows";
    }
}