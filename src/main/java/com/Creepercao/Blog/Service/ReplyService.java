package com.Creepercao.Blog.Service;

import com.Creepercao.Blog.Entity.Reply;
import com.Creepercao.Blog.dao.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    // 获取所有回复
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    // 根据评论 ID 获取回复
    public List<Reply> getRepliesByCommentId(Integer commentId) {
        return replyRepository.findByComment(commentId);
    }

    // 检查回复是否存在
    public boolean existsById(Integer id) {
        return replyRepository.existsById(id);
    }

    // 删除回复
    public void deleteReply(Integer id) {
        replyRepository.deleteById(id);
    }

    // 保存或更新回复
    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }
}
