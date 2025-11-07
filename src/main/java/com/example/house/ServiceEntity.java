package com.example.house;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String image;
    private String category;
    private String badge;
    private String badgeColor;
    private double rating;
    private int reviews;
    private String price;

    @Column(length = 1000)
    private String description;

    @ElementCollection
    private List<String> features;

    // Constructors
    public ServiceEntity() {
    }

    public ServiceEntity(String title, String image, String category, String badge, 
                        String badgeColor, double rating, int reviews, String price, 
                        String description, List<String> features) {
        this.title = title;
        this.image = image;
        this.category = category;
        this.badge = badge;
        this.badgeColor = badgeColor;
        this.rating = rating;
        this.reviews = reviews;
        this.price = price;
        this.description = description;
        this.features = features;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getBadge() { return badge; }
    public void setBadge(String badge) { this.badge = badge; }

    public String getBadgeColor() { return badgeColor; }
    public void setBadgeColor(String badgeColor) { this.badgeColor = badgeColor; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getReviews() { return reviews; }
    public void setReviews(int reviews) { this.reviews = reviews; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getFeatures() { return features; }
    public void setFeatures(List<String> features) { this.features = features; }
}

