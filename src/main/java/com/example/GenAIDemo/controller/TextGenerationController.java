package com.example.GenAIDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GenAIDemo.service.TextGenerationService;

@RestController
public class TextGenerationController {
    @Autowired
    TextGenerationService textGenerationService;

    @PostMapping(value = "/interact")
    public ResponseEntity<String> interactWithGenAi(
            @RequestBody String questionString) {
        String response = textGenerationService.interctResponse(questionString);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/detectFraud")
    public ResponseEntity<String> analyzSentiment(@RequestBody String input) {
        String response = textGenerationService.analyzSentiment(input);

        return ResponseEntity.ok(response);
    }
}
