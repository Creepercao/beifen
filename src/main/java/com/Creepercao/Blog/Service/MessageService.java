package com.Creepercao.Blog.Service;

import com.Creepercao.Blog.Entity.Message;
import com.Creepercao.Blog.Entity.User;
import com.Creepercao.Blog.Entity.Article;
import com.Creepercao.Blog.Entity.Comment;
import com.Creepercao.Blog.Entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserService userService;

    // 获取文章点赞的消息
    public List<Message> getArticleLikeMessages(Integer articleId) {
        List<Message> messages = new ArrayList<>();
        // 获取文章信息
        Optional<Article> articleOptional = articleService.getArticleById(articleId);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            // 创建点赞消息
            Message message = new Message();
            message.setType("LIKE");
            message.setArticleId((long) articleId);
            message.setContent("您的文章《" + article.getTitle() + "》获得了新的点赞");
            message.setLikes(article.getLikes());
            message.setTime(LocalDateTime.now());

            // 获取点赞者的信息
            List<User> users = userService.getAllUsers(); // 或者根据需求获取特定用户
            for (User user : users) {
                message.setUserId(String.valueOf(user.getUuid()));
                message.setUserName(user.getName());
                message.setUserAvatar(user.getAvatar());
            }

            messages.add(message);
        }
        return messages;
    }

    // 获取评论消息
    public List<Message> getCommentMessages(Integer articleId) {
        List<Message> messages = new ArrayList<>();
        // 获取评论列表
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        for (Comment comment : comments) {
            // 创建评论消息
            Message message = new Message();
            message.setType("COMMENT");
            message.setArticleId((long) articleId);
            message.setCommentId((long) comment.getId());
            message.setContent("您的文章《" + comment.getArticleId() + "》收到了一条新的评论");
            message.setLikes(comment.getLikes());
            message.setTime(LocalDateTime.now());

            // 获取评论者的信息
            Optional<User> userOptional = userService.getUserById(Integer.valueOf(comment.getUserUuid()));
            userOptional.ifPresent(user -> {
                message.setUserId(String.valueOf(user.getUuid()));
                message.setUserName(user.getName());
                message.setUserAvatar(user.getAvatar());
            });

            messages.add(message);
        }
        return messages;
    }

    // 获取回复消息（楼中楼）
    public List<Message> getReplyMessages(Integer commentId) {
        List<Message> messages = new ArrayList<>();
        // 获取该评论的所有回复
        List<Reply> replies = replyService.getRepliesByCommentId(commentId);
        for (Reply reply : replies) {
            // 创建楼中楼回复消息
            Message message = new Message();
            message.setType("REPLY");
            message.setCommentId((long) commentId);
            message.setReplyId((long) reply.getId());
            message.setContent("您的评论获得了一条新的回复");
            message.setLikes(reply.getLikes());
            message.setTime(LocalDateTime.now());

            // 获取回复者的信息
            Optional<User> userOptional = userService.getUserById(reply.getUser());
            userOptional.ifPresent(user -> {
                message.setUserId(String.valueOf(user.getUuid()));
                message.setUserName(user.getName());
                message.setUserAvatar(user.getAvatar());
            });

            messages.add(message);
        }
        return messages;
    }
}
