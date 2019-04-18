package com.soft1721.jianyue.api.controller;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.VO.LikeVO;
import com.soft1721.jianyue.api.service.LikeService;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/like")
public class LikeController {
    @Resource
    private LikeService likeService;
    @PostMapping("/add")
    public ResponseResult likeUser(@RequestParam("fromId") int fromId, @RequestParam("toId") int toId) {
        Like like=new Like();
        like.setFromId(fromId);
        like.setToId(toId);
        likeService.insertLike(like);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelFollow(@RequestParam("fromId") int fromId, @RequestParam("toId") int toId) {
        likeService.deleteLike(fromId, toId);
        return ResponseResult.success();
    }
    @GetMapping("/list")
    public ResponseResult LikeAll(@RequestParam("fromId") int fromId){
        List<LikeVO> list=likeService.getLikeById(fromId);
        return  ResponseResult.success(list);
    }
}
