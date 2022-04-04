package com.psk1.persistence;

import com.psk1.entities.Exhibition;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ExhibitionsDAO {

    @Inject
    private EntityManager em;

    public List<Exhibition> loadAll() {
        return em.createNamedQuery("Exhibition.findAll", Exhibition.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Exhibition exhibition){
        this.em.persist(exhibition);
    }

    public Exhibition findOne(Long id) {
        return em.find(Exhibition.class, id);
    }
}
