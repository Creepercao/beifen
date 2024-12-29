package com.Creepercao.Blog.dao;

import com.Creepercao.Blog.Entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    // 根据评论 ID 查找回复
    List<Reply> findByComment(Integer commentId);
}
