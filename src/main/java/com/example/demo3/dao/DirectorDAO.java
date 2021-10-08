package com.example.demo3.dao;

import com.example.demo3.data.Director;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class DirectorDAO {
    @PersistenceContext
    EntityManager em;

    public List<Director> findAll() {
        return em.createQuery("select d from Director d", Director.class).getResultList();
    }

    public Director find(int dId) {
        return em.find(Director.class, dId);
    }

    public void add(Director director) {
        em.persist(director);
    }

    public void delete(int id) {
        Director director = em.find(Director.class, id);
        em.remove(director);
    }
}
