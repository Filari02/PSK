package com.psk1.useCases;

import com.psk1.entities.Exhibition;
import com.psk1.persistence.ExhibitionsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Exhibitions {

    @Inject
    private ExhibitionsDAO exhibitionsDAO;

    @Getter@Setter
    private Exhibition exhibitionToCreate = new Exhibition();

    @Getter
    private List<Exhibition> allExhibitions;

    @PostConstruct
    public void init() {loadAllExhibitions();}

    @Transactional
    public void createExhibition() {this.exhibitionsDAO.persist(exhibitionToCreate);}

    private void loadAllExhibitions() {
        this.allExhibitions = exhibitionsDAO.loadAll();}
}
