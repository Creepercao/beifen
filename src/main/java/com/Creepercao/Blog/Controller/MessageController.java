package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.Message;
import com.Creepercao.Blog.Entity.User;
import com.Creepercao.Blog.Service.ArticleService;
import com.Creepercao.Blog.Service.CommentService;
import com.Creepercao.Blog.Service.ReplyService;
import com.Creepercao.Blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserService userService;

    // 获取所有点赞和评论的消息
    @GetMapping
    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();

        // 获取所有点赞消息
        articleService.getAllArticles().forEach(article -> {
            if (article.getLikes() != null && article.getLikes() > 0) {
                Message message = new Message();
                message.setType("LIKE");
                message.setArticleId((long) article.getAid());
                message.setLikes(article.getLikes());
                message.setTime(LocalDateTime.now());
                Optional<User> user = userService.getUserById(article.getUuid());
                user.ifPresent(u -> {
                    message.setUserId(u.getUuid().toString());
                    message.setUserName(u.getName());
                    message.setUserAvatar(u.getAvatar());
                });
                message.setContent("你的文章有新的点赞.");
                messages.add(message);
            }
        });

        // 获取所有评论消息
        commentService.getAllComments().forEach(comment -> {
            Message message = new Message();
            message.setType("COMMENT");
            message.setArticleId((long) comment.getArticleId());
            message.setCommentId((long) comment.getId());
            message.setTime(comment.getTime());
            Optional<User> user = userService.getUserById(Integer.valueOf(comment.getUserUuid()));
            user.ifPresent(u -> {
                message.setUserId(u.getUuid().toString());
                message.setUserName(u.getName());
                message.setUserAvatar(u.getAvatar());
            });
            message.setContent("你的文章有新的评论.");
            messages.add(message);
        });

        // 获取所有楼中楼回复消息
        replyService.getAllReplies().forEach(reply -> {
            Message message = new Message();
            message.setType("REPLY");
            message.setArticleId((long) reply.getComment());
            message.setCommentId((long) reply.getComment());
            message.setReplyId((long) reply.getId());
            message.setTime(reply.getTime());
            Optional<User> user = userService.getUserById(reply.getUser());
            user.ifPresent(u -> {
                message.setUserId(u.getUuid().toString());
                message.setUserName(u.getName());
                message.setUserAvatar(u.getAvatar());
            });
            message.setContent("你的评论有了新的回复.");
            messages.add(message);
        });

        return messages;
    }

    // 获取特定用户的消息
    @GetMapping("/user/{userId}")
    public List<Message> getMessagesByUserId(@PathVariable String userId) {
        List<Message> messages = new ArrayList<>();

        // 获取点赞消息
        articleService.getAllArticles().forEach(article -> {
            if (article.getLikes() != null && article.getLikes() > 0) {
                Optional<User> user = userService.getUserById(article.getUuid());
                if (user.isPresent() && user.get().getUuid().toString().equals(userId)) {
                    Message message = new Message();
                    message.setType("LIKE");
                    message.setArticleId((long) article.getAid());
                    message.setLikes(article.getLikes());
                    message.setTime(LocalDateTime.now());
                    message.setUserId(user.get().getUuid().toString());
                    message.setUserName(user.get().getName());
                    message.setUserAvatar(user.get().getAvatar());
                    message.setContent("你的文章有新的点赞.");
                    messages.add(message);
                }
            }
        });

        // 获取评论消息
        commentService.getAllComments().forEach(comment -> {
            Optional<User> user = userService.getUserById(Integer.valueOf(comment.getUserUuid()));
            if (user.isPresent() && user.get().getUuid().toString().equals(userId)) {
                Message message = new Message();
                message.setType("COMMENT");
                message.setArticleId((long) comment.getArticleId());
                message.setCommentId((long) comment.getId());
                message.setTime(comment.getTime());
                message.setUserId(user.get().getUuid().toString());
                message.setUserName(user.get().getName());
                message.setUserAvatar(user.get().getAvatar());
                message.setContent("你的文章有新的评论");
                messages.add(message);
            }
        });

        // 获取楼中楼回复消息
        replyService.getAllReplies().forEach(reply -> {
            Optional<User> user = userService.getUserById(reply.getUser());
            if (user.isPresent() && user.get().getUuid().toString().equals(userId)) {
                Message message = new Message();
                message.setType("REPLY");
                message.setArticleId((long) reply.getComment());
                message.setCommentId((long) reply.getComment());
                message.setReplyId((long) reply.getId());
                message.setTime(reply.getTime());
                message.setUserId(user.get().getUuid().toString());
                message.setUserName(user.get().getName());
                message.setUserAvatar(user.get().getAvatar());
                message.setContent("你的评论有了新的回复");
                messages.add(message);
            }
        });

        return messages;
    }

}
