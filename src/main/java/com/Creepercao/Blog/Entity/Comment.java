package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity // 标注为 JPA 实体类
@Table(name = "comments") // 对应数据库中的 comments 表
public class Comment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Getter 和 Setter 方法
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增策略
    @Column(name = "id") // 对应数据库中的列名
    private Integer id;

    @Column(name = "article_id", nullable = false) // 存储文章的 ID，外键
    private Integer articleId; // 文章的 ID

    @Column(name = "user_uuid", nullable = false) // 存储用户的 UUID，外键
    private String userUuid; // 用户的 UUID

    @Column(nullable = false, columnDefinition = "TEXT") // 评论内容
    private String content;

    @Column(nullable = false, columnDefinition = "DATETIME") // 评论时间，默认为当前时间
    private LocalDateTime time;

    @Column(nullable = true, columnDefinition = "INT DEFAULT 0") // 点赞数，默认为 0
    private Integer likes;

    @PrePersist
    public void prePersist() {
        if (this.time == null) {
            this.time = LocalDateTime.now();
        }
        if (this.likes == null)
            this.likes = 0;
    }
    // 无参构造器
    public Comment() {
    }

    // 全参构造器
    public Comment(Integer articleId, String userUuid, String content, LocalDateTime time, Integer likes) {
        this.articleId = articleId;
        this.userUuid = userUuid;
        this.content = content;
        this.time = time;
        this.likes = likes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userUuid='" + userUuid + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likes=" + likes +
                '}';
    }
}
