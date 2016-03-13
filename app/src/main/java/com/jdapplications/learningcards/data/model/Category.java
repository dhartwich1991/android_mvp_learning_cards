package com.jdapplications.learningcards.data.model;

import com.squareup.moshi.Json;

/**
 * @author daniel.hartwich
 */
public class Category {
    @Json(name = "name")
    private String name;
    @Json(name = "subject")
    private String subject;
    @Json(name = "id")
    private int id;

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String subject() {
        return subject;
    }

    public void subject(String subject) {
        this.subject = subject;
    }

    public int id() {
        return id;
    }

    public void id(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{"
              + "name='" + name + '\''
              + ", subject='" + subject + '\''
              + ", id=" + id + '}';
    }
}
