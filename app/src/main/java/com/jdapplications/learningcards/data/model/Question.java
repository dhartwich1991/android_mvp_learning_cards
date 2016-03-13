package com.jdapplications.learningcards.data.model;

import com.squareup.moshi.Json;

/**
 * @author daniel.hartwich
 */
public class Question {
    @Json(name = "id")
    private int id;
    @Json(name = "question")
    private String question;
    @Json(name = "image_url")
    private String imageUrl;
    @Json(name = "category_id")
    private String categoryId;

    @Json(name = "created_at")
    private String createdAt;
    @Json(name = "updated_at")
    private String updatedAt;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question The question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return The noAnsewered
     */
//    public Object getNoAnsewered() {
//        return noAnsewered;
//    }
//
//    /**
//     * @param noAnsewered The no_ansewered
//     */
//    public void setNoAnsewered(int noAnsewered) {
//        this.noAnsewered = noAnsewered;
//    }

    /**
     * @return The imageUrl
     */
    public Object getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId The category_id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return The typeId
     */
//    public Object getTypeId() {
//        return typeId;
//    }
//
//    /**
//     * @param typeId The type_id
//     */
//    public void setTypeId(int typeId) {
//        this.typeId = typeId;
//    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
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
}
