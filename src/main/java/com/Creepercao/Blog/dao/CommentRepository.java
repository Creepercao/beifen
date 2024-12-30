package com.Creepercao.Blog.dao;

import com.Creepercao.Blog.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    // 根据文章 ID 查询评论
    List<Comment> findByArticleId(Integer articleId);

    // 根据用户 UUID 查询评论
    List<Comment> findByUserUuid(Integer userUuid);

    // 判断评论是否存在
    boolean existsById(Integer id);
}
