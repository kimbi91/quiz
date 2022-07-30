package hu.progmatic.quiz.service;

import hu.progmatic.quiz.model.SingleChoiceQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SingleChoiceService {

    private long counter = 0;

    Map<Long, SingleChoiceQuestion> questions = new TreeMap<>();

    public SingleChoiceService() {
        SingleChoiceQuestion question1 = new SingleChoiceQuestion("Mi Magyarország fővárosa?", 1, "Budapest", "Sopron", "Győr", "Debrecen");
        SingleChoiceQuestion question2 = new SingleChoiceQuestion("Mi Németország fővárosa?", 2, "München", "Berlin", "Köln", "Frankfurt am Main");
        saveQuestion(question1);
        saveQuestion(question2);
    }

    public List<SingleChoiceQuestion> getAll() {
        return new ArrayList<>(questions.values());
    }

    public SingleChoiceQuestion getById(Long id) {
        return questions.get(id);
    }

    public SingleChoiceQuestion saveQuestion(SingleChoiceQuestion question) {
        if (question.getId() == null) {
            counter++;
            question.setId(counter);
        }

        questions.put(question.getId(), question);

        return question;
    }
}
