package com.example.GenAIDemo.utils;

import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.vertexai.VertexAiLanguageModel;

public class TextGenerationUtils {
    public static PromptTemplate dataTraining() {
        PromptTemplate promptTemplate = PromptTemplate.from("""
                Analyze the text below. Respond to describe is it fraud.

                INPUT: Action now! You only get one chance!
                OUTPUT: It's very likely a scam email based on your input.

                INPUT: Required! Click below link and change your password!
                OUTPUT: It's very likely a scam email based on your input.

                INPUT: How are you?
                OUTPUT: It's not likely a scam email based on your input.

                INPUT: We've drop some of our fee.
                OUTPUT: It's not likely a scam email based on your input.

                INPUT: 72 HOURS ONLY: Up to 15% off flights
                OUTPUT: It's not likely a scam email based on your input.

                INPUT: Up to £100 off city breaks
                OUTPUT: It's not likely a scam email based on your input.

                INPUT: {{text}}
                OUTPUT:
                """);

        return promptTemplate;
    }

    public static VertexAiLanguageModel modelBuild() {
        VertexAiLanguageModel model = VertexAiLanguageModel.builder()
                .endpoint("us-central1-aiplatform.googleapis.com:443")
                .project("your-project-id")
                .location("us-central1")
                .publisher("google")
                .modelName("text-bison@001")
                .maxOutputTokens(50)
                .topK(10)
                .topP(0.1)
                .build();

        return model;
    }

}
