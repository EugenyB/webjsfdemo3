package com.example.demo3.beans;

import com.example.demo3.dao.DirectorDAO;
import com.example.demo3.data.Director;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DirectorBean implements Serializable {

    @EJB
    DirectorDAO directorDAO;

    private Director director = new Director();

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Director> getDirectors() {
        return directorDAO.findAll();
    }

    public String films(int dId) {
        director = directorDAO.find(dId);
        return "filmsbydirector";
    }
}
