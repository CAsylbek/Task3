package com.task3.task3.rerository;

import com.task3.task3.model.TextDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends ElasticsearchRepository<TextDoc, String> {

    Iterable<TextDoc> findByText(String text);

    void save(TextDoc textDoc);

    void delete(TextDoc textDoc);

    TextDoc findById(String id);
}
