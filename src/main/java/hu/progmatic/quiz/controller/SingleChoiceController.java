package hu.progmatic.quiz.controller;

import hu.progmatic.quiz.model.SingleChoiceQuestion;
import hu.progmatic.quiz.service.SingleChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SingleChoiceController {

    SingleChoiceService singleChoiceService;

    public SingleChoiceController(SingleChoiceService singleChoiceService) {
        this.singleChoiceService = singleChoiceService;
    }

    @GetMapping("/singlechoices")
    public String getSingleChoiceQuestions(Model model) {
        List<SingleChoiceQuestion> questions = singleChoiceService.getAll();

        model.addAttribute("questions", questions);

        return "singlechoices";
    }
}
