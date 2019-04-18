package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.VO.FollowVO;
import com.soft1721.jianyue.api.service.FollowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceImplTest {
    @Resource
    private FollowService followService;

    @Test
    public void getFollow() {
        Follow followVO = followService.getFollow(1,4);
        System.out.println(followVO);
    }

    @Test
    public void getFollowsByUId() {
        List<FollowVO> followVO = followService.getFollowsByUId(1);
        System.out.println(followVO);
    }

    @Test
    public void insertFollow() {
        Follow follow = new Follow();
        follow.setFromUId(4);
        follow.setToUId(11);
        followService.insertFollow(follow);
    }

    @Test
    public void deleteFollow() {
        followService.deleteFollow(1,4);


    }
}
