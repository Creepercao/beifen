package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private Integer aid;

    @Column(name = "UUID")
    private Integer uuid;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 将 tags 存储为 JSON 字符串（或者可以使用逗号分隔的字符串等格式）
    @Column(name = "tags", columnDefinition = "TEXT")
    private String tags;

    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column
    private String name;

    // 无参构造函数
    public Article() {
    }

    // 带参数构造函数
    public Article(String title, String content, String tags, Integer uuid, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.uuid = uuid;
        this.createdAt = createdAt;
    }
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now(); // 设置当前时间为创建时间
        }
    }

    // 设置 tags 为 List<String> 类型
    public void setTagsList(List<String> tagsList) {
        this.tags = tagsList.stream().collect(Collectors.joining(",")); // 使用逗号分隔符将 List 转换为字符串
    }

    // 获取 tags 为 List<String> 类型
    public List<String> getTagsList() {
        if (this.tags != null && !this.tags.isEmpty()) {
            return List.of(this.tags.split(",")); // 使用逗号分隔符将字符串转换为 List
        }
        return List.of(); // 如果没有标签，则返回空列表
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
                ", name='" + name + '\'' +
                '}';
    }
}
