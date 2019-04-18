package com.soft1721.jianyue.api.entity.VO;

import lombok.Data;

import java.util.Date;
@Data
public class CommentVO {
    private Integer id;
    private Integer uId;
    private Integer aId;
    private String content;
    private Date commentTime;
    private String nickname;
    private String avatar;

}
