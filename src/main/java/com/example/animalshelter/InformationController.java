package com.example.animalshelter;

import com.example.animalshelter.adopter.AnimalAdopterService;
import com.example.animalshelter.employee.EmployeeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/information")
@Controller
public class InformationController {

    EmployeeService employeeService;
    AdoptionHistoryService adoptionHistoryService;
    AnimalService animalService;
    AnimalAdopterService animalAdopterService;

    public InformationController(EmployeeService employeeService, AdoptionHistoryService adoptionHistoryService, AnimalService animalService, AnimalAdopterService animalAdopterService) {
        this.employeeService = employeeService;
        this.adoptionHistoryService = adoptionHistoryService;
        this.animalService = animalService;
        this.animalAdopterService = animalAdopterService;
    }

    @GetMapping("/animals")
    String adoptedAnimals(@RequestParam boolean adopted, Model model){
        if (adopted){
            model.addAttribute("animals", animalService.findAllAdopted());
        }else {
            model.addAttribute("animals", animalService.findAllNoAdopted());
        }

        return "info-animals";
    }
//    @GetMapping("/noAdoptedAnimals")
//    String noAdoptedAnimals(Model model){
//        animalService.findAllNoAdopted();
//
//        return "";
//    }

    @GetMapping("/history")
    String adoptionHistory(Model model){

        model.addAttribute("histories", adoptionHistoryService.findAll());
        return "info-history";
    }

    @GetMapping("/adopters")
    String animalAdopters(Model model){
        model.addAttribute("adopters", animalAdopterService.findAll());

        return "info-adopters";
    }

    @GetMapping("/employees")
    String employees(Model model){
        List<EmployeeDTO> all = employeeService.findAll();
        model.addAttribute("employees", all);

        return "info-employees";
    }
}
