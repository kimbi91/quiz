package hu.progmatic.quiz.service;

import hu.progmatic.quiz.model.LogMessage;
import hu.progmatic.quiz.model.SingleChoiceQuestion;
import hu.progmatic.quiz.repository.LogMessageRepository;
import hu.progmatic.quiz.repository.SingleChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SingleChoiceService {
    private SingleChoiceRepository singleChoiceRepository;

    private LogMessageRepository logMessageRepository;

    private long counter = 0;

    Map<Long, SingleChoiceQuestion> questions = new TreeMap<>();

    public SingleChoiceService(SingleChoiceRepository singleChoiceRepository, LogMessageRepository logMessageRepository) {
        this.singleChoiceRepository = singleChoiceRepository;
        this.logMessageRepository = logMessageRepository;
    }

    public List<SingleChoiceQuestion> getAll() {
        return new ArrayList<>((Collection) singleChoiceRepository.findAll());
    }

    public SingleChoiceQuestion getById(Long id) {
        return singleChoiceRepository.findById(id).get();
    }

    public SingleChoiceQuestion saveQuestion(SingleChoiceQuestion question) {
        singleChoiceRepository.save(question);

        logMessageRepository.save(new LogMessage("New singleChoice saved."));

        return question;
    }
}
