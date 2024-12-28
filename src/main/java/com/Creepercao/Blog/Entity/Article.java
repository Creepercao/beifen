package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "article")
public class Article {
    // Getter 和 Setter 方法
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private Long aid;

    @Column(name = "UUID")
    private Integer uuid;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(length = 255)
    private String tags;

    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column
    private String name;

    public Article() {
    }

    public Article(String title, String content, String tags, Integer uuid, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.uuid = uuid;
        this.createdAt = createdAt;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", uuid=" + uuid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                ", createdAt=" + createdAt +
                ", name=" + name +
                '}';
    }
}
