package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.VO.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Resource
//    private ArticleMapper articleMapper;
    private ArticleService articleService;
    @Test
    public void selectAll() {
        /*List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs(articleMapper.selectImgByaId(articleVO.getId()));
        }
        System.out.println(articles);*/
        List<ArticleVO> article=articleService.selectAll();
        System.out.println(article);
    }

    @Test
    public void getArticleById() {
//        ArticleVO articleVO = articleMapper.getArticleById(1);
//        List<Img> imgList = new ArrayList<>();
//        imgList = articleMapper.selectImgByaId(1);
//        articleVO.setImgs(imgList);
//        System.out.println(articleVO);
        ArticleVO articleVO=articleService.getArticleById(1);
        System.out.println(articleVO);
    }
    @Test
    public void selectImgByaId() {
//        List<Img> list = new ArrayList<>();
//        list = articleMapper.selectImgByaId(1);
//        System.out.println(list);
    }
    @Test
    public void insertArticle(){
        Article article=new Article();
        article.setTitle("set");
        article.setContent("111");
        article.setUId(1);
        articleService.insertArticle(article);
    }
    @Test
    public void getArticleByuId(){
        List<ArticleVO>articleVOS=articleService.getArticleByuId(1);
        System.out.println(articleVOS);
    }

}