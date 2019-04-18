package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.VO.LikeVO;

import java.util.List;

public interface LikeService {
    Like getLike(int fromId,int toId);

    List<LikeVO> getLikeById(int fromId);

    void insertLike(Like like);

    void deleteLike(int fromId, int toId);
}
