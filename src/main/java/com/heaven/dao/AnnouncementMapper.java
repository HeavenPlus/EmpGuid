package com.heaven.dao;

import com.heaven.bean.Announcement;
import com.heaven.bean.AnnouncementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnouncementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    long countByExample(AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int deleteByExample(AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int insert(Announcement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int insertSelective(Announcement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    List<Announcement> selectByExampleWithBLOBs(AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    List<Announcement> selectByExample(AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    Announcement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int updateByExampleSelective(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int updateByExample(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int updateByPrimaryKeySelective(Announcement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Announcement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table announcement
     *
     * @mbg.generated Sat Apr 13 00:37:32 CST 2019
     */
    int updateByPrimaryKey(Announcement record);
}