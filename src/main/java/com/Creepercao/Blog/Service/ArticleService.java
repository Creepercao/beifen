package com.Creepercao.Blog.Service;

import com.Creepercao.Blog.Entity.Article;
import com.Creepercao.Blog.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    // 获取所有文章
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // 根据文章ID获取文章
    public Optional<Article> getArticleById(Long aid) {
        return articleRepository.findById(aid);
    }

    // 创建或更新文章
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    // 删除文章
    public void deleteArticle(Long aid) {
        articleRepository.deleteById(aid);
    }

    // 根据标题过滤文章
    public List<Article> filterArticlesByTitle(String title) {
        return articleRepository.findAll().stream()
                .filter(article -> article.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }

}