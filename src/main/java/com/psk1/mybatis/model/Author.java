package com.psk1.mybatis.model;

import java.util.List;

public class Author {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.AUTHOR.ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.AUTHOR.NAME
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    private String name;

    private List<Artwork> artworks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.AUTHOR.ID
     *
     * @return the value of PUBLIC.AUTHOR.ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.AUTHOR.ID
     *
     * @param id the value for PUBLIC.AUTHOR.ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.AUTHOR.NAME
     *
     * @return the value of PUBLIC.AUTHOR.NAME
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.AUTHOR.NAME
     *
     * @param name the value for PUBLIC.AUTHOR.NAME
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}