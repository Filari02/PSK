package com.psk1.mybatis.model;

import java.util.List;

public class Artwork {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ARTWORK.ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ARTWORK.ARTWORKNAME
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    private String artworkname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ARTWORK.EXHIBITION_ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    private Long exhibitionId;

    private Exhibition exhibition;

    private List<Author> authors;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ARTWORK.ID
     *
     * @return the value of PUBLIC.ARTWORK.ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ARTWORK.ID
     *
     * @param id the value for PUBLIC.ARTWORK.ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ARTWORK.ARTWORKNAME
     *
     * @return the value of PUBLIC.ARTWORK.ARTWORKNAME
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public String getArtworkname() {
        return artworkname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ARTWORK.ARTWORKNAME
     *
     * @param artworkname the value for PUBLIC.ARTWORK.ARTWORKNAME
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public void setArtworkname(String artworkname) {
        this.artworkname = artworkname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ARTWORK.EXHIBITION_ID
     *
     * @return the value of PUBLIC.ARTWORK.EXHIBITION_ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public Long getExhibitionId() {
        return exhibitionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ARTWORK.EXHIBITION_ID
     *
     * @param exhibitionId the value for PUBLIC.ARTWORK.EXHIBITION_ID
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    public void setExhibitionId(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }
}