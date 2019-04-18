package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Article;

import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.VO.ArticleVO;

import java.util.List;

public interface ArticleService {
    /*查询所有*/
    List<ArticleVO> selectAll();

    /*通过文章id查询文章信息*/
    ArticleVO getArticleById(int aId);

    void insertArticle(Article article);

    List<ArticleVO>getArticleByuId(int uId);

    List<ArticleVO>selectByuId(int uId);
}
