package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.Reply;
import com.Creepercao.Blog.Service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    // 获取所有回复
    @GetMapping
    public List<Reply> getAllReplies() {
        return replyService.getAllReplies();
    }

    // 根据评论 ID 获取所有回复
    @GetMapping("/comment/{commentId}")
    public List<Reply> getRepliesByCommentId(@PathVariable("commentId") Integer commentId) {
        return replyService.getRepliesByCommentId(commentId);
    }

    // 删除回复
    @DeleteMapping("/{id}")
    public String deleteReply(@PathVariable("id") Integer id) {
        if (replyService.existsById(id)) {
            replyService.deleteReply(id);
            return "回复删除成功";
        } else {
            return "回复未找到";
        }
    }

    // 保存或更新回复
    @PostMapping
    public String saveOrUpdateReply(@RequestBody Reply reply) {
        replyService.saveReply(reply);
        return "回复保存成功";
    }
}
