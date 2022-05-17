package com.psk1.persistence;

import com.psk1.entities.Artwork;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ArtworksDAO {

    @Inject
    private EntityManager em;

    public void persist(Artwork artwork){
        this.em.persist(artwork);
    }

    public Artwork findOne(Integer id) {
        return em.find(Artwork.class, id);
    }

    public Artwork update(Artwork artwork) {
        return em.merge(artwork);
    }
}
