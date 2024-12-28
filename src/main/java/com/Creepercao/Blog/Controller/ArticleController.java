package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.Article;
import com.Creepercao.Blog.Service.UserService;
import com.Creepercao.Blog.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;


    // 获取所有文章
    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // 删除文章
    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable("id") Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return "文章删除成功";
        } else {
            return "文章未找到";
        }
    }
    @PostMapping
    public String saveOrUpdateArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return "文章保存成功";
    }
}
