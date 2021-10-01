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
}
