package com.Kafka.Movie.Model;

public class Movie {

    private String name;
    private String genre;
    private String actor;
    private int year;

    public Movie(){}

    public Movie(String name, String genre, String actor, int year) {
        this.name = name;
        this.genre = genre;
        this.actor = actor;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", actor='" + actor + '\'' +
                ", year=" + year +
                '}';
    }
}
