package com.liugx.testsystem.mapper;

import com.liugx.testsystem.model.UserAndTest;
import com.liugx.testsystem.model.UserAndTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserAndTestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    long countByExample(UserAndTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int deleteByExample(UserAndTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int insert(UserAndTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int insertSelective(UserAndTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    List<UserAndTest> selectByExampleWithRowbounds(UserAndTestExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    List<UserAndTest> selectByExample(UserAndTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    UserAndTest selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserAndTest record, @Param("example") UserAndTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int updateByExample(@Param("record") UserAndTest record, @Param("example") UserAndTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int updateByPrimaryKeySelective(UserAndTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userandtest
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    int updateByPrimaryKey(UserAndTest record);
}