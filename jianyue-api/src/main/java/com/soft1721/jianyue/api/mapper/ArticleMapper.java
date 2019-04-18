package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.VO.ArticleVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "comment", column = "comment"),
            @Result(property = "creatTime", column = "creat_time"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "avatar",column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.u_id=b.id ORDER By id DESC")
    List<ArticleVO> selectAll();
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "uId", column = "u_id"),
//            @Result(property = "title", column = "title"),
//            @Result(property = "comment", column = "comment"),
//            @Result(property = "creatTime", column = "creat_time")
//    })
//    @Select("SELECT*FROM t_article WHERE u_id=#{uId}")
//    ArticleVO getArticleById(int aId);
//    List<Img> selectImgByaId(Integer id);
@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "uId", column = "u_id"),
        @Result(property = "title", column = "title"),
        @Result(property = "content", column = "content"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "nickname", column = "nickname"),
        @Result(property = "avatar", column = "avatar")
})
@Select("SELECT a.*, b.nickname, b.avatar, c.img_url \n" +
        "FROM t_article AS a LEFT JOIN t_user AS b ON a.u_id = b.id \n" +
        "LEFT JOIN t_img AS c ON a.id = c.a_id\n" +
        "WHERE a.id = #{aId}")
ArticleVO getArticleById(int aId);

@Select("SELECT * FROM t_article WHERE u_id=#{uId}")
List<ArticleVO>getArticleByuId(int uId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "aId", column = "a_id"),
            @Result(property = "imgs", column = "img_url")
    })
    @Select("SELECT * FROM t_img WHERE a_id = #{aId}")
    List<Img> selectImgByaId(int aId);
    @Insert("INSERT INTO t_article (u_id,title,content,create_time) VALUES (#{uId},#{title},#{content},#{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertArticle(Article article);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a left JOIN t_user b ON a.u_id=b.id WHERE a.u_id=#{uId} ORDER By id DESC")
    List<ArticleVO> selectByuId(int uId);

}

