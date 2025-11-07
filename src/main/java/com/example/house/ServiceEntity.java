package com.example.house;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;

    @Column(length = 1000)
    private String longDescription;

    private double price;
    private String icon;
    private String category;
    private String image;
    private String gradient;
    private boolean featured;

    @ElementCollection
    @JsonProperty("features")
    private List<String> includes;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getGradient() { return gradient; }
    public void setGradient(String gradient) { this.gradient = gradient; }

    public boolean isFeatured() { return featured; }
    public void setFeatured(boolean featured) { this.featured = featured; }

    public List<String> getIncludes() { return includes; }
    public void setIncludes(List<String> includes) { this.includes = includes; }
}

