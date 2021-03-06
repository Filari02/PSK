package com.psk1.persistence;

import com.psk1.entities.Author;
import com.psk1.entities.Exhibition;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuthorsDAO {

    @Inject
    private EntityManager em;

    public List<Author> loadAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Author author){
        this.em.persist(author);
    }

    public Author findOne(Integer id) {
        return em.find(Author.class, id);
    }

    public Author update(Author author){
        return em.merge(author);
    }

}
