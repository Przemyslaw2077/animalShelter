package com.example.animalshelter.animal;

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

    @GetMapping("/delete")
    String deleteAnimal(@RequestParam AnimalStatistics.Species species,
                        @RequestParam Long animalToDeleteId){
        animalService.deleteAnimal(animalToDeleteId,species);
        return "redirect:/animal/delete/confirmation";
    }

    @GetMapping("/add")
    String addAnimalToShelter(@RequestParam AnimalStatistics.Species species,
                              @RequestParam(required = false) Long animalToEditId, Model model){
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
        model.addAttribute("animalToEditId", animalToEditId);
        return "add-animal";
    }

    @PostMapping("/add")
    String addAnimalToShelter(AnimalDTO animalDTO,  @RequestParam(required = false) AnimalStatistics.DogRace dogRace,
                              @RequestParam(required = false) Long animalToEditId,
                              @RequestParam(required = false) AnimalStatistics.CatRace catRace){
        animalService.saveOrUpdateAnimal(animalDTO, catRace, dogRace, animalToEditId);
        return "redirect:/animal/add/confirmation";
    }

    @GetMapping("/add/confirmation")
    String addConfirmed(Model model){
        model.addAttribute("message", "Wszystko się udało, zwierze zostało dodane");
        return "message";
    }

    @GetMapping("/delete/confirmation")
    String deleteConfirmed(Model model){
        model.addAttribute("message", "Wszystko się udało, zwierze zostało usunięte");
        return "message";
    }
}