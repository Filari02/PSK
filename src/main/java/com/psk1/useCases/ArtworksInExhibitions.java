package com.psk1.useCases;

import com.psk1.entities.Artwork;
import com.psk1.entities.Exhibition;
import com.psk1.persistence.ArtworksDAO;
import com.psk1.persistence.ExhibitionsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class ArtworksInExhibitions implements Serializable {

    @Inject
    private ArtworksDAO artworksDAO;

    @Inject
    private ExhibitionsDAO exhibitionsDAO;

    @Getter@Setter
    private Exhibition exhibition;



    public List<Artwork> getExhibitionArtworks (Exhibition exhibition) {
        this.exhibition = exhibitionsDAO.findOne(exhibition.getId());
        System.out.println(this.exhibition.getName());
        return this.exhibition.getArtworks();

    }

//    @PostConstruct
//    public void init() {
//        Map<String, String> requestParameters =
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        Integer exhibitionId = Integer.parseInt(requestParameters.get("exhibitionId"));
//        this.exhibition = exhibitionsDAO.findOne(exhibitionId);
//    }
}
