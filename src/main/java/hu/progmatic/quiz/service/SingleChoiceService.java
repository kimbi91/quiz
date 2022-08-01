package hu.progmatic.quiz.service;

import hu.progmatic.quiz.model.SingleChoiceQuestion;
import hu.progmatic.quiz.repository.SingleChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SingleChoiceService {
    private SingleChoiceRepository repository;

    private long counter = 0;

    Map<Long, SingleChoiceQuestion> questions = new TreeMap<>();

    public SingleChoiceService(SingleChoiceRepository repository) {
        this.repository = repository;
    }

    public List<SingleChoiceQuestion> getAll() {
        return new ArrayList<>((Collection) repository.findAll());
    }

    public SingleChoiceQuestion getById(Long id) {
        return repository.findById(id).get();
    }

    public SingleChoiceQuestion saveQuestion(SingleChoiceQuestion question) {
        repository.save(question);

        return question;
    }
}
