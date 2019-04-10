package com.heaven.dao;

import com.heaven.bean.Recruit;
import com.heaven.bean.RecruitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    long countByExample(RecruitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int deleteByExample(RecruitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int insert(Recruit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int insertSelective(Recruit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    List<Recruit> selectByExample(RecruitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    Recruit selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int updateByExampleSelective(@Param("record") Recruit record, @Param("example") RecruitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int updateByExample(@Param("record") Recruit record, @Param("example") RecruitExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int updateByPrimaryKeySelective(Recruit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recruit
     *
     * @mbg.generated Sun Mar 31 17:05:13 CST 2019
     */
    int updateByPrimaryKey(Recruit record);
}