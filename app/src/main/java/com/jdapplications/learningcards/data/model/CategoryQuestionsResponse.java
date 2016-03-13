package com.jdapplications.learningcards.data.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daniel.hartwich
 */
public class CategoryQuestionsResponse {
    @Json(name = "question")
    private Question question;
    @Json(name = "answers")
    private List<Answer> answers = new ArrayList<>();

    /**
     * @return The question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question The question
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * @return The answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers The answers
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
