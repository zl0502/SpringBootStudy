package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.VO.LikeVO;
import com.soft1721.jianyue.api.service.LikeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LikeServiceImplTest {
    @Resource
    private LikeService likeService;
    @Test
    public void getLike() {
        Like likeVO=likeService.getLike(1,3);
        System.out.println(likeVO);
    }

    @Test
    public void getLikeById() {
        List<LikeVO> likeVO=likeService.getLikeById(1);
        System.out.println(likeVO);
    }

    @Test
    public void insertLike() {
        Like like=new Like();
        like.setToId(2);
        like.setFromId(1);
        likeService.insertLike(like);
    }

    @Test
    public void deleteLike() {
        likeService.deleteLike(1,2);
    }
}