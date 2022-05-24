package com.psk1.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtworkDTO {

    private Integer id;

    private String name;

    private ExhibitionDTO exhibition;

    private List<AuthorDTO> authors;

}


