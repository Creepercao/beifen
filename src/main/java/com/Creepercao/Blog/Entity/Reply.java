package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity // 标注为 JPA 实体类
@Table(name = "replies") // 对应数据库中的 replies 表
public class Reply implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Getter 和 Setter 方法
    @Setter
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增策略
    @Column(name = "id") // 对应数据库中的列名
    private Integer id;

    @Setter
    @Column(name = "comment_id", nullable = false)
    private Integer comment; // 评论对应id

    @Setter
    @Column(name = "user_uuid", nullable = false)
    private Integer user; // 用户对应id

    @Setter
    @Column(nullable = false, columnDefinition = "TEXT") // 回复内容
    private String content;

    @Setter
    @Column(nullable = false, columnDefinition = "DATETIME") // 回复时间
    private LocalDateTime time;

    @Setter
    @Column(nullable = true) // 点赞数
    private Integer likes;

    // 无参构造器
    public Reply() {
    }

    // 全参构造器
    @PrePersist
    public void prePersist() {
        if (this.time == null) {
            this.time = LocalDateTime.now();
        }
        if (this.likes == null)
            this.likes = 0;
    }


    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", comment=" + comment +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likes=" + likes +
                '}';
    }
}
