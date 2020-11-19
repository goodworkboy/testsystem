package com.liugx.testsystem.mapper;

import com.liugx.testsystem.model.Paper;
import com.liugx.testsystem.model.PaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PaperMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    long countByExample(PaperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int deleteByExample(PaperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int insert(Paper record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int insertSelective(Paper record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    List<Paper> selectByExampleWithRowbounds(PaperExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    List<Paper> selectByExample(PaperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    Paper selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int updateByPrimaryKeySelective(Paper record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper
     *
     * @mbg.generated Wed Nov 18 12:08:04 CST 2020
     */
    int updateByPrimaryKey(Paper record);
}