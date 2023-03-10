package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "Image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String description;


    private String dimensions;


    @ManyToOne
    @JoinColumn
    Blog blog;

    public Image(String description, String dimension) {
        this.description = description;
        this.dimensions = dimension;
    }

    public Image(Blog blog,String description,String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimension) {
        this.dimensions = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image() {
    }
}
