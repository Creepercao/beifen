package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    // Getter 和 Setter 方法
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private Integer aid;

    @Setter
    @Getter
    @Column(name = "UUID")
    private Integer uuid;

    @Setter
    @Column(nullable = false, length = 255)
    private String title;

    @Setter
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Setter
    @Column(length = 255)
    private String tags;

    @Setter
    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Setter
    @Column
    private String name;

    @Setter
    @Getter
    @Column
    private Integer likes;

    @Setter
    @Getter
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean is_top;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        if (this.likes == null)
            this.likes = 0;
        if (this.is_top==null){
            this.is_top=false;
        }
    }


    public Article() {
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
                ", like=" + likes +
                ", is_top=" + is_top +
                '}';
    }
}
