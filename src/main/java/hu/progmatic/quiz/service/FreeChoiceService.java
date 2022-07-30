package hu.progmatic.quiz.service;

import hu.progmatic.quiz.model.FreeChoiceQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class FreeChoiceService {

    private long counter = 0;

    Map<Long, FreeChoiceQuestion> questions = new TreeMap<>();

    public FreeChoiceService() {
        FreeChoiceQuestion question1 = new FreeChoiceQuestion("Mi Magyarország fővárosa?", "Budapest");
        FreeChoiceQuestion question2 = new FreeChoiceQuestion("Mi Németország fővárosa?", "Berlin");
        saveQuestion(question1);
        saveQuestion(question2);
    }

    public List<FreeChoiceQuestion> getAll() {
        return new ArrayList<>(questions.values());
    }

    public FreeChoiceQuestion getById(Long id) {
        return questions.get(id);
    }

    public FreeChoiceQuestion saveQuestion(FreeChoiceQuestion question) {
        if (question.getId() == null) {
            counter++;
            question.setId(counter);
        }

        questions.put(question.getId(), question);

        return question;
    }
}
