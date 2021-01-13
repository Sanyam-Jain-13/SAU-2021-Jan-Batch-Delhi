package com.employee.employeeExample.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Blog {

    @Id
    String id;
    String topic;
    String author;
    List<String> tags;
    Date date;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public Blog(String id, String topic, String author, List<String> tags, Date date) {
        super();
        this.id = id;
        this.topic = topic;
        this.author = author;
        this.tags = tags;
        this.date = date;
    }

}
