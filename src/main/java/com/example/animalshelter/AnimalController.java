package com.example.animalshelter;

import com.example.animalshelter.animal.AnimalDTO;
import com.example.animalshelter.animal.AnimalStatistics;
import com.example.animalshelter.animal.CatDTO;
import com.example.animalshelter.animal.DogDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/animal")
@Controller
public class AnimalController {

    private AnimalService animalService;



    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/details")
    String details(@RequestParam Long id, @RequestParam AnimalStatistics.Species species, Model model){

        model.addAttribute("animalDetails", animalService.findAnimalById(id, species));
        return "animal-details";

    }

    @GetMapping("/add")
    String addAnimalToShelter(@RequestParam AnimalStatistics.Species species, Model model){
        if (species.equals(AnimalStatistics.Species.CAT)){
            CatDTO cat = new CatDTO();
            cat.setSpecies(species);
            model.addAttribute("newAnimal", cat);
            model.addAttribute("races", AnimalStatistics.CatRace.values());
        }else {
            DogDTO dog = new DogDTO();
            dog.setSpecies(species);
            model.addAttribute("newAnimal", dog);
            model.addAttribute("races", AnimalStatistics.DogRace.values());
        }
        model.addAttribute("genders", AnimalStatistics.Gender.values());
        model.addAttribute("ages", AnimalStatistics.Age.values());
        model.addAttribute("sizes", AnimalStatistics.Size.values());
        return "add-animal";

    }

    @PostMapping("/add")
    String addAnimalToShelter(AnimalDTO animalDTO,  @RequestParam(required = false) AnimalStatistics.DogRace dogRace,
                                                    @RequestParam(required = false) AnimalStatistics.CatRace catRace){
        animalService.saveAnimal(animalDTO, catRace, dogRace);
        return "redirect:/animal/add/confirmation";

    }

    @GetMapping("/add/confirmation")
    String addConfirmed(Model model){
        model.addAttribute("message", "Wszystko się udało, zwierze zostało dodane");
        return "message";
    }
}
