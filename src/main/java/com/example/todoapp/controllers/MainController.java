package com.example.todoapp.controllers;

import com.example.todoapp.models.Models;
import com.example.todoapp.services.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@CrossOrigin
public class MainController {

    private ModelService modelService;

    public MainController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/")
    public String index(Models models) {
        models.addAttribute("Models", modelService.getModelsList());
        return "index";
    }

    @GetMapping("/add")
    public String addModels(@ModelAttribute Models models) {
        modelService.addModels(models);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateTask(@ModelAttribute Models models) {
        modelService.updateModels(models);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam(value = "models") String title) {
        modelService.deleteModels(title);
        return "redirect:/";
    }

    @GetMapping("/updateinfo")
    public String updateInfo(@RequestParam(value = "model") String title, Model model) {
        Models model2 = modelService.getModelsByTitle(title);
        model.addAttribute("model", model2);
        return "update";
    }
}
