package com.psk1.useCases;

import com.psk1.entities.Artwork;
import com.psk1.entities.Author;
import com.psk1.entities.Exhibition;
import com.psk1.persistence.ArtworksDAO;
import com.psk1.persistence.AuthorsDAO;
import com.psk1.persistence.ExhibitionsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class ArtworksWithAuthors {

    @Inject
    private ArtworksDAO artworksDAO;

    @Inject
    private AuthorsDAO authorsDAO;

    @Getter
    @Setter
    private Artwork artwork;

    @Getter @Setter
    private Author authorToCreate = new Author();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer artworkId = Integer.parseInt(requestParameters.get("artworkId"));
        this.artwork = artworksDAO.findOne(artworkId);
    }

    @Transactional
    public void createAuthor() {
        List<Artwork> artworks = authorToCreate.getArtworks();
        if(artworks == null) {
            artworks = new ArrayList<Artwork>();
        }
        artworks.add(this.artwork);
        authorToCreate.setArtworks(artworks);
        authorsDAO.persist(authorToCreate);


        List<Author> authors = this.artwork.getAuthors();
        if(authors == null) {
            authors = new ArrayList<Author>();
        }
        authors.add(authorToCreate);
        this.artwork.setAuthors(authors);
        artworksDAO.update(this.artwork);
    }
}
