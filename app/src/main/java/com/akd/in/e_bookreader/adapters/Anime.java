package com.akd.in.e_bookreader.adapters;

import java.io.Serializable;

public class Anime implements Serializable {

    private String name;
    private String Description;
    private String rating;
    private int nb_episode;
    private String categorie;
    private String studio;
    private String img_url;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int episode, String categorie, String studio, String img_url) {
        this.name = name;
        this.Description = description;
        this.rating = rating;
        this.nb_episode = episode;
        this.categorie = categorie;
        this.studio = studio;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
