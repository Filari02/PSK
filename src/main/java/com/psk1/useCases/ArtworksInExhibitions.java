package com.psk1.useCases;

import com.psk1.entities.Artwork;
import com.psk1.entities.Exhibition;
import com.psk1.persistence.ArtworksDAO;
import com.psk1.persistence.ExhibitionsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class ArtworksInExhibitions implements Serializable {

    @Inject
    private ExhibitionsDAO exhibitionsDAO;

    @Inject
    private ArtworksDAO artworksDAO;

    @Getter
    @Setter
    private Exhibition exhibition;

    @Getter @Setter
    private Artwork artworkToCreate = new Artwork();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer exhibitionId = Integer.parseInt(requestParameters.get("exhibitionId"));
        this.exhibition = exhibitionsDAO.findOne(exhibitionId);
    }

    @Transactional
    public void createArtwork() {
        artworkToCreate.setExhibition(this.exhibition);
        artworksDAO.persist(artworkToCreate);
    }
}