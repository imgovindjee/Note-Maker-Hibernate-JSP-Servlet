package com.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    @Column(length = 2000)
    private String content;
    private String title;
    private Date addedDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }


    /**
     *
     * {@AllArgsConstructor}
     */
    public Note() {
        super();
    }

    public Note(String title, String content, Date addedDate){
        super();
        this.title = title;
        this.addedDate = addedDate;
        this.content = content;
    }
}