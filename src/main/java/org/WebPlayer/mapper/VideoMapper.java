package org.WebPlayer.mapper;

import org.WebPlayer.dto.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMapper {
    // 根据 bv 号查询视频
    @Select("""
            select bv,
                   type,
                   category,
                   title,
                   cover,
                   introduction,
                   publish_time,
                   tags
            from video
            where bv=#{bv}
            """)
    Video findByBv(String bv);
    /*
        数据库习惯 underscore 下划线分隔多个单词 如 ：publish_time
        Java 习惯 驼峰命名法 camel case 如 ：publishTime
     */

    @Insert("""
            insert into video(type, category, title, cover, introduction, publish_time, tags)
            VALUES (#{type}, #{category}, #{title}, #{cover}, #{introduction}, #{publishTime}, #{tags})
            """)
    void insert(Video video);

    // 获取最近生成的自增主键值
    @Select("select last_insert_id()")
    int lastInsertId();

    // 更新 bv 号
    @Update("update video set bv=#{bv} where id=#{id}")
    void updateBv(@Param("bv") String bv, @Param("id") int id);
}
