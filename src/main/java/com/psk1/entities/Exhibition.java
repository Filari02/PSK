package com.psk1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Exhibition.findAll", query = "select e from Exhibition as e")
})
@Table(name = "EXHIBITION")
@Getter@Setter
public class Exhibition implements Serializable {

    public Exhibition(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "exhibition")
    private List<Artwork> artworks;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;
}
