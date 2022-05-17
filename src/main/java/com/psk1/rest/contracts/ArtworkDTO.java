package com.psk1.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtworkDTO {

    private Integer id;

    private String artworkName;

    private String exhibitionName;

    private List<AuthorDTO> authors;

}
