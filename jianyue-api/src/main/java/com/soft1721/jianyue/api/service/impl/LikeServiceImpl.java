package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Like;
import com.soft1721.jianyue.api.entity.VO.LikeVO;
import com.soft1721.jianyue.api.mapper.LikeMapper;
import com.soft1721.jianyue.api.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeMapper likeMapper;
    @Override
    public Like getLike(int fromId, int toId) {
        return likeMapper.getLike(fromId,toId);
    }

    @Override
    public List<LikeVO> getLikeById(int fromId) {
        return likeMapper.getLikeById(fromId);
    }

    @Override
    public void insertLike(Like like) {
        likeMapper.insertLike(like);
    }

    @Override
    public void deleteLike(int fromId, int toId) {
        likeMapper.deleteLike(fromId,toId);
    }
}
