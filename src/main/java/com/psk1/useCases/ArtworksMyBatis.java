package com.psk1.useCases;


import com.psk1.mybatis.dao.ArtworkMapper;
import com.psk1.mybatis.dao.ExhibitionMapper;
import com.psk1.mybatis.model.Artwork;
import com.psk1.mybatis.model.Exhibition;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ArtworksMyBatis {

    @Inject
    private ArtworkMapper artworkMapper;

    @Getter
    private List<Artwork> allArtworks;

    @PostConstruct
    public void init() {
        this.loadAllArtworks();
    }

    private void loadAllArtworks() {
        this.allArtworks = artworkMapper.selectAll();
    }


}
