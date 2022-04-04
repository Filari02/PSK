package com.psk1.useCases;


import com.psk1.mybatis.dao.ExhibitionMapper;
import com.psk1.mybatis.model.Exhibition;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ExhibitionsMyBatis {

    @Inject
    private ExhibitionMapper exhibitionMapper;

    @Getter
    private List<Exhibition> allExhibitions;

    private Exhibition createExhibition;

    @Getter @Setter
    private Exhibition exhibitionToCreate = new Exhibition();

    @PostConstruct
    public void init() {
        this.loadAllExhibitions();
    }

    private void loadAllExhibitions() {
        this.allExhibitions = exhibitionMapper.selectAll();
    }

    @Transactional
    public String createExhibition() {
        exhibitionMapper.insert(exhibitionToCreate);
        return "/myBatis/exhibitions?faces-redirect=true";
    }
}
