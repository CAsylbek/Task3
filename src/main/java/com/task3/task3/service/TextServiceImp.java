package com.task3.task3.service;

import com.task3.task3.model.TextDoc;
import com.task3.task3.rerository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImp implements TextService{

    private TextRepository textRepository;

    @Autowired
    TextServiceImp(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public void save(TextDoc textDoc) {
        textRepository.save(textDoc);
    }

    public void delete(TextDoc textDoc) {
        textRepository.delete(textDoc);
    }

    public TextDoc findById(String id) {
        return textRepository.findById(id);
    }

    public Iterable<TextDoc> findByText(String text) {
        return textRepository.findByText(text);
    }
}
