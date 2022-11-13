package com.example.animalshelter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalDetailsController {

    private AnimalDetailsService animalDetailsService;

    public AnimalDetailsController(AnimalDetailsService animalDetailsService) {
        this.animalDetailsService = animalDetailsService;
    }

    @GetMapping("/details")
    String details(@RequestParam String name, @RequestParam AnimalStatistics.Species species, Model model){

        model.addAttribute("animalDetails", animalDetailsService.animalDetails(name, species));
        return "animal-details";

    }
}
