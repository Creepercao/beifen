package com.Creepercao.Blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String type;           // 消息类型：LIKE, COMMENT, REPLY
    private Long articleId;        // 文章 ID (适用于点赞和评论)
    private Long commentId;        // 评论 ID (适用于楼中楼)
    private Long replyId;          // 楼中楼 ID (仅适用于楼中楼消息)
    private String userId;         // 用户 UUID
    private String userName;       // 用户名
    private String userAvatar;     // 用户头像
    private String content;        // 消息内容
    private Integer likes;         // 点赞数
    private LocalDateTime time;    // 消息时间
}