package com.example.animalshelter;

import com.example.animalshelter.animal.AnimalStatistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private AnimalService animalService;

    public HomeController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/")
    String home(@RequestParam(required = false) AnimalStatistics.Species specie,
                @RequestParam(required = false) AnimalStatistics.Gender gender, Model model){

        if (specie == null){
            if (gender == null){
                model.addAttribute("animals", animalService.findAllNoAdopted());
            }else {
                model.addAttribute("animals",animalService.findAllByGender(gender));
            }
        } else
         model.addAttribute("animals", animalService.findAllBySpecies(specie));

        return "index";
    }
}
