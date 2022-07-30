package hu.progmatic.quiz.controller;

import hu.progmatic.quiz.model.FreeChoiceQuestion;
import hu.progmatic.quiz.service.FreeChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FreeChoiceController {

    private FreeChoiceService freeChoiceService;

    public FreeChoiceController(FreeChoiceService freeChoiceService) {
        this.freeChoiceService = freeChoiceService;
    }

    @GetMapping("/freechoices")
    public String getFreeChoiceQuestions(Model model) {
        List<FreeChoiceQuestion> questions = freeChoiceService.getAll();
        model.addAttribute("questions", questions);

        return "freechoices";
    }
}
