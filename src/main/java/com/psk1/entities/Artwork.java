package com.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter@Setter
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "ArtworkName")
    private String name;

    @ManyToOne
    private Exhibition exhibition;


    @ManyToMany
    private List<Author> authors;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

}
