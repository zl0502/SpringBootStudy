package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.VO.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ImgMapper imgMapper;

    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs(imgMapper.selectImgsByAId(articleVO.getId()));
        }
        return articles;
    }

    @Override
    public ArticleVO getArticleById(int aId) {

        return articleMapper.getArticleById(aId);
    }

//    @Override
//    public List<Img> selectImgByaId(int aId) {
//
//        return articleMapper.selectImgByaId(aId);
//    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public List<ArticleVO> selectByuId(int uId) {
        return articleMapper.selectByuId(uId);
    }

    @Override
    public List<ArticleVO> getArticleByuId(int uId) {
        List<ArticleVO> articles = articleMapper.getArticleByuId(uId);
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs((imgMapper.selectImgsByAId(articleVO.getId())));
        }
        return articles;
    }

}
