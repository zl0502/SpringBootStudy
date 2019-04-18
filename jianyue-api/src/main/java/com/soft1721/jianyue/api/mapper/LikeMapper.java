package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.VO.LikeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LikeMapper {
        @Results({
                @Result(property = "id", column = "id"),
                @Result(property = "fromId", column = "from_id"),
                @Result(property = "toId", column = "to_id")
        })
        @Select("SELECT * FROM t_like WHERE from_id = #{fromId} AND to_id = #{toId} ")
        Like getLike(@Param("fromId") int fromId, @Param("toId") int toId);


        @Results({
                @Result(property = "toId", column = "to_id"),
                @Result(property = "createTime", column = "create_time"),
                @Result(property = "title", column = "title")
        })
        @Select("SELECT a.to_id,b.create_time,b.title FROM t_like a LEFT JOIN t_article b ON a.to_id = b.id WHERE a.from_id = #{fromId}  ")
        List<LikeVO> getLikeById(int fromId);

        @Insert("INSERT INTO t_like (from_id,to_id) VALUES (#{fromId},#{toId}) ")
        void insertLike(Like like);

        @Delete("DELETE  FROM t_like WHERE from_id = #{fromId} AND to_id = #{toId} ")
        void deleteLike(@Param("fromId") int fromId, @Param("toId") int toId);



}
