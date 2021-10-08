package com.example.demo3.data;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    public Director(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Director() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id && Objects.equals(name, director.name) && Objects.equals(country, director.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "director")
    private Collection<Movie> films;

    public Collection<Movie> getFilms() {
        return films;
    }

    public void setFilms(Collection<Movie> films) {
        this.films = films;
    }
}
