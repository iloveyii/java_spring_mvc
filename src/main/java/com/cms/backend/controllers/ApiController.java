package com.cms.backend.controllers;

import com.cms.backend.data.InquiryRepository;
import com.cms.backend.data.QuestionRepository;
import com.cms.backend.models.Inquiry;
import com.cms.backend.models.Question;
import com.cms.backend.models.Response;
import com.cms.backend.models.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ApiController {

    @Autowired
    QuestionRepository questionRepository;

    @Value("${server.api}")
    private String serverApi;

    Logger logger = LogManager.getLogger(ApiController.class);

    @PutMapping("/api/v1/inquiries/{id}")
    public Result updateQuoteInquiry(@PathVariable  Integer id, @RequestBody Question form) throws JsonProcessingException {
        Result result = new Result(true, "status changed to " + form.getStatus() );
        Optional<Question> question =  questionRepository.findById(id);

        if(question.isPresent()) {
            Question q = question.get();
            q.setStatus(form.getStatus());
            questionRepository.save(q);
        }
        return result;
    }

    @DeleteMapping("/api/v1/inquiries/{id}")
    public Result deleteQuestion(@PathVariable  Integer id) throws JsonProcessingException {
        Result result = new Result(true, "Inquiry deleted with _id " + id );
        Optional<Question> question =  questionRepository.findById(id);

        if(question.isPresent()) {
            questionRepository.deleteById(id);
        }
        return result;
    }

    @PostMapping("/api/v1/inquiries")
    public Result createQuestion(@RequestBody Question q) throws JsonProcessingException {
        q.setStatus(2);
        questionRepository.save(q);
        return new Result(true, "Saved to H2");
    }

     @GetMapping("/api/v1/inquiries")
     public Response getQuestions(Model model, @RequestHeader String host) throws JsonProcessingException {
        return new Response(true, questionRepository.findAll());
    }
}
