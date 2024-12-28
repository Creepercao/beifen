package com.Creepercao.Blog.dao;

import com.Creepercao.Blog.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    // 根据文章 ID 查找评论
    List<Comment> findByArticleId(Integer articleId);
}
