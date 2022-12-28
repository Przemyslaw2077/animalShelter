package com.example.animalshelter.adopter;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalAdopterController {

    AnimalAdopterService animalAdopterService;

    public AnimalAdopterController(AnimalAdopterService animalAdopterService) {
        this.animalAdopterService = animalAdopterService;
    }

    @GetMapping("/create")
    String createAdopter(Model model){
        AnimalAdopterDTO animalAdopterDTO = new AnimalAdopterDTO();
        model.addAttribute("animalAdopter",animalAdopterDTO);
        return "create-adopter";

    }

    @PostMapping("/create")
    String createAdopter(AnimalAdopterDTO animalAdopterDTO){
        animalAdopterService.saveAnimalAdopter(animalAdopterDTO);

        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    String creationConfirmed(Model model){
        model.addAttribute("message", "Wszystko się udało, stworzon nową osoba adoptującą");
        return "message";
    }

}
