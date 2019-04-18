package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.entity.VO.CommentVO;
import com.soft1721.jianyue.api.mapper.CommentMapper;
import com.soft1721.jianyue.api.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private CommentService commentService;

    @Test
    public void selectCommentsByAId() {
        List<CommentVO> list = new ArrayList<>();
        list = commentMapper.selectCommentsByAId(1);
        System.out.println(list);
    }
    @Test
    public void addComment() {
        Comment comment = new Comment();
        comment.setAId(2);
        comment.setUId(4);
        comment.setContent("very good!");
        /* comment.setCommentTime(new Date(2019,04,10,9,43,35));*/
        commentService.addComment(comment);
    }

}