package com.Creepercao.Blog.dao;

import com.Creepercao.Blog.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    // 根据标题查找文章
    List<Article> findByTitle(String title);

    // 根据 UUID 查找文章
    List<Article> findByUuid(Integer uuid);

    // 根据标题包含的关键词查找文章
    List<Article> findByTitleContaining(String keyword);

}
