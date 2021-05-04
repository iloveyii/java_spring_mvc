package com.cms.backend.data;

import com.cms.backend.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository <Question, Integer> {
}
