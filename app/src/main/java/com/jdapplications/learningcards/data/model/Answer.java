package com.jdapplications.learningcards.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

/**
 * @author daniel.hartwich
 */
public class Answer implements Parcelable {
    @Json(name = "id")
    private Integer id;
    @Json(name = "answer")
    private String answer;
    @Json(name = "question_id")
    private String questionId;
    @Json(name = "correct")
    private Boolean correct;
    @Json(name = "created_at")
    private String createdAt;
    @Json(name = "updated_at")
    private String updatedAt;

    /**
     * @return The id
     */
    @Json(name = "id")
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @Json(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The answer
     */
    @Json(name = "answer")
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer The answer
     */
    @Json(name = "answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return The questionId
     */
    @Json(name = "question_id")
    public String getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId The question_id
     */
    @Json(name = "question_id")
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    /**
     * @return The correct
     */
    @Json(name = "correct")
    public Boolean getCorrect() {
        return correct;
    }

    /**
     * @param correct The correct
     */
    @Json(name = "correct")
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    /**
     * @return The createdAt
     */
    @Json(name = "created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    @Json(name = "created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.answer);
        dest.writeString(this.questionId);
        dest.writeValue(this.correct);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
    }

    public Answer() {
    }

    private Answer(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.answer = in.readString();
        this.questionId = in.readString();
        this.correct = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };
}
