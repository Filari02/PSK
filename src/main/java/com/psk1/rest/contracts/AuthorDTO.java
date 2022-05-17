package com.psk1.rest.contracts;

import com.psk1.entities.Artwork;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class AuthorDTO {

    private Integer id;

    private String name;

    private List<ArtworkDTO> artworks;
}
