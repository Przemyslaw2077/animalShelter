package com.example.animalshelter;

import com.example.animalshelter.adopter.AnimalAdopterService;
import com.example.animalshelter.animal.AnimalStatistics;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/animal")
public class AdoptController {

    private AnimalService animalService;
    private AnimalAdopterService animalAdopterService;
    private AdoptionHistoryService adoptionHistoryService;

    public AdoptController(AnimalService animalService, AnimalAdopterService animalAdopterService, AdoptionHistoryService adoptionHistoryService) {
        this.animalService = animalService;
        this.animalAdopterService = animalAdopterService;
        this.adoptionHistoryService = adoptionHistoryService;
    }

    @GetMapping("/adopt")
    String adopt(@RequestParam Long animalId, @RequestParam AnimalStatistics.Species species, Model model){
        AdoptionHistory adoptionHistory = new AdoptionHistory();

        model.addAttribute("adopters",animalAdopterService.findAll());
        model.addAttribute("adoptionHistory",adoptionHistory);
        model.addAttribute("animal", animalService.findAnimalById(animalId,species));

        Long a = 4L;


        return "adopt";

    }

    @PostMapping("/adopt")
    String adopt(Authentication authentication, @RequestParam Long animalId, @RequestParam AnimalStatistics.Species species,
                 @RequestParam Long adopterId, Model model){
        adoptionHistoryService.saveAdoption(authentication.getName(), animalId, species, adopterId);
//        AnimalDTO animalByName = animalService.findAnimalByName(name, species);
        model.addAttribute("message", "Wszystko się udało! "+ species.getTranslation()
                +" "+ " została zaadoptowany przez: "+adopterId);
        return "redirect:/animal/adopt/confirmation";

    }

    @GetMapping("/adopt/confirmation")
    String addConfirmed(Model model){
        model.addAttribute("message", "Wszystko się udało, zwierze zostało zaadoptowane");
        return "message";
    }




}
