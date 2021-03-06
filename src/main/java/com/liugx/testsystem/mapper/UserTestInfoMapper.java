package com.liugx.testsystem.mapper;

import com.liugx.testsystem.model.UserTestInfo;
import com.liugx.testsystem.model.UserTestInfoExample;
import com.liugx.testsystem.model.UserTestInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserTestInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    long countByExample(UserTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int deleteByExample(UserTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int deleteByPrimaryKey(UserTestInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int insert(UserTestInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int insertSelective(UserTestInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    List<UserTestInfo> selectByExampleWithRowbounds(UserTestInfoExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    List<UserTestInfo> selectByExample(UserTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    UserTestInfo selectByPrimaryKey(UserTestInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserTestInfo record, @Param("example") UserTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int updateByExample(@Param("record") UserTestInfo record, @Param("example") UserTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int updateByPrimaryKeySelective(UserTestInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usertestinfo
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    int updateByPrimaryKey(UserTestInfo record);
}