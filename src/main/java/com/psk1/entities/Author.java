package com.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter@Setter
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "select e from Author as e")
})
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Artwork> artworks;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;
}
