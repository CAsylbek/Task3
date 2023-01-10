package com.task3.task3.service;

import com.task3.task3.model.TextDoc;

import java.io.IOException;

public interface TextService {

    void save(TextDoc textDoc) throws IOException;

    void delete(TextDoc textDoc);


    TextDoc findById(String id);

    Iterable<TextDoc> findByText(String text);
}
