package com.psk1.mybatis.dao;

import com.psk1.mybatis.model.Exhibition;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ExhibitionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXHIBITION
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXHIBITION
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    int insert(Exhibition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXHIBITION
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    Exhibition selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXHIBITION
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    List<Exhibition> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXHIBITION
     *
     * @mbg.generated Fri Apr 01 14:50:09 EEST 2022
     */
    int updateByPrimaryKey(Exhibition record);
}