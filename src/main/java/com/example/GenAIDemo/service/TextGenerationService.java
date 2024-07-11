package com.example.GenAIDemo.service;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.vertexai.VertexAiLanguageModel;

@Service
public class TextGenerationService {

    public String interctResponse(String questionString) {
        VertexAiLanguageModel model = VertexAiLanguageModel.builder()
                .endpoint("us-central1-aiplatform.googleapis.com:443")
                .project("my-genai-project-429014")
                .location("us-central1")
                .publisher("google")
                .modelName("text-bison@001")
                .maxOutputTokens(20)
                .build();

        Response<String> response = model.generate(questionString);

        return response.content();
    }
}
