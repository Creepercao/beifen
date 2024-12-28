package com.Creepercao.Blog.Service;

import com.Creepercao.Blog.Entity.Comment;
import com.Creepercao.Blog.dao.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // 获取所有评论
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // 根据文章 ID 获取评论
    public List<Comment> getCommentsByArticleId(Integer articleId) {
        return commentRepository.findByArticleAid(articleId);
    }

    // 检查评论是否存在
    public boolean existsById(Integer id) {
        return commentRepository.existsById(id);
    }

    // 删除评论
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

    // 保存或更新评论
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
