package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity // 标注为 JPA 实体类
@Table(name = "comments") // 对应数据库中的 comments 表
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增策略
    @Column(name = "id") // 对应数据库中的列名
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) // 多对一关系，评论属于一个文章
    @JoinColumn(name = "article_id", referencedColumnName = "AID", nullable = false)
    private Article article; // 文章实体

    @ManyToOne(fetch = FetchType.LAZY) // 多对一关系，评论属于一个用户
    @JoinColumn(name = "user_uuid", referencedColumnName = "UUID", nullable = false)
    private User user; // 用户实体

    @Column(nullable = false, columnDefinition = "TEXT") // 评论内容
    private String content;

    @Column(nullable = false, columnDefinition = "DATETIME") // 评论时间
    private LocalDateTime time;

    @Column(nullable = true) // 点赞数
    private Integer likes;

    // 无参构造器
    public Comment() {
    }

    // 全参构造器
    public Comment(Article article, User user, String content, LocalDateTime time, Integer likes) {
        this.article = article;
        this.user = user;
        this.content = content;
        this.time = time;
        this.likes = likes;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", article=" + article +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likes=" + likes +
                '}';
    }
}
