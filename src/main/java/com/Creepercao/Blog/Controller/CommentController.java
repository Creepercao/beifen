package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.Comment;
import com.Creepercao.Blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 获取所有评论
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // 根据文章 ID 获取评论
    @GetMapping("/article/{articleId}")
    public List<Comment> getCommentsByArticleId(@PathVariable("articleId") Integer articleId) {
        return commentService.getCommentsByArticleId(articleId);
    }

    // 根据用户 UUID 获取评论
    @GetMapping("/user/{userUuid}")
    public List<Comment> getCommentsByUserUuid(@PathVariable("userUuid") Integer userUuid) {
        return commentService.getCommentsByUserUuid(userUuid);
    }

    // 删除评论
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable("id") Integer id) {
        if (commentService.existsById(id)) {
            commentService.deleteComment(id);
            return "评论删除成功";
        } else {
            return "评论未找到";
        }
    }

    // 保存评论
    @PostMapping
    public String saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
        return "评论保存成功";
    }
}
