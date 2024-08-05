package com.example.GenAIDemo.utils;

import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.vertexai.VertexAiLanguageModel;

public class TextGenerationUtils {
    public static PromptTemplate dataTraining() {
        PromptTemplate promptTemplate = PromptTemplate.from("""
                Analyze the text below. Respond only with one word to describe is it fraud.

                INPUT: Act now! You only get one chance!
                OUTPUT: POSITIVE

                INPUT: Click here to claim yous cash prize!
                OUTPUT: POSITIVE

                INPUT: How are you?
                OUTPUT: NEGATIVE

                INPUT: We've drop some of our fee.
                OUTPUT: NEGATIVE

                INPUT: {{text}}
                OUTPUT:
                """);

        return promptTemplate;
    }

    public static VertexAiLanguageModel modelBuild() {
        VertexAiLanguageModel model = VertexAiLanguageModel.builder()
                .endpoint("us-central1-aiplatform.googleapis.com:443")
                .project("my-genai-project-429014")
                .location("us-central1")
                .publisher("google")
                .modelName("text-bison@001")
                .maxOutputTokens(20)
                .build();

        return model;
    }

}
