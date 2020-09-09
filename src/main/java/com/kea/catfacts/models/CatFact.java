package com.kea.catfacts.models;

import java.util.Date;

public class CatFact implements Comparable<CatFact>
{
    public String text;
    public String type;
    public Date createdAt;
    public Date updatedAt;

    public CatFact(String text, String type, Date createdAt, Date updatedAt)
    {
        this.text = text;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        return "Created at: + " + createdAt + "--- Fact: " + text + "<br/>";
    }

    @Override
    public int compareTo(CatFact o) {

        if(this.getCreatedAt().before(o.getCreatedAt()))
        {
            return -1;
        }

        if(this.getCreatedAt().after(o.getCreatedAt()))
        {
            return 1;
        }

        return 0;
    }

}
