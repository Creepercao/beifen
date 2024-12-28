package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.Article;
import com.Creepercao.Blog.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    // 根据 uuid 获取所有文章
    @GetMapping("/uuid/{uuid}")
    public List<Article> getArticlesByUuid(@PathVariable("uuid") Integer uuid) {
        // 根据 uuid 查找所有相关的文章
        return articleRepository.findByUuid(uuid);
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

    // 保存或更新文章
    @PostMapping
    public String saveOrUpdateArticle(@RequestBody Article article) {
        try {
            // 如果文章主体内容存在图片或附件，保存文件并处理路径
            String content = article.getContent();
            if (content.contains("src=\"/article")) {
                // 假设图片的路径以"/article"为前缀，我们将图片保存到特定路径
                String updatedContent = saveImagesFromContent(content);
                article.setContent(updatedContent);
            }
            // 保存文章
            articleRepository.save(article);
            return "文章保存成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "保存文章失败";
        }
    }
    @PostMapping("/upload-image")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
        String uploadDir = "/path/to/save/images/";  // 图片存储路径
        String fileName = UUID.randomUUID().toString() + ".jpg";  // 或根据需要处理文件名
        try {
            // 保存文件到指定路径
            File destFile = new File(uploadDir + fileName);
            file.transferTo(destFile);

            // 返回图片的 URL（假设已配置静态资源映射）
            String imageUrl = "/article/" + fileName;
            Map<String, String> response = new HashMap<>();
            response.put("url", imageUrl);

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 将文章内容中的图片保存到本地并更新路径
    private String saveImagesFromContent(String content) throws IOException {
        // 正则表达式：匹配 src 属性中的路径
        String regex = "src=\"(/article[^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        // 替换图片路径
        StringBuffer updatedContent = new StringBuffer();
        while (matcher.find()) {
            // 获取图片路径
            String imagePath = matcher.group(1).substring(1);  // 去掉前缀"/"

            // 假设图片存储路径
            File file = new File("article", imagePath);  // 将图片路径构造为本地路径
            if (!file.exists()) {
                Files.createDirectories(Paths.get(file.getParent())); // 创建目录
                // 假设这里有上传文件的逻辑，文件需要转移到本地
                // MultipartFile imageFile = new MultipartFile(imagePath); // 假设这里有上传文件的逻辑
                // imageFile.transferTo(file); // 假设这里有上传文件的逻辑
            }

            // 替换匹配的路径
            matcher.appendReplacement(updatedContent, "src=\"/article" + imagePath + "\"");
        }

        // 完成替换操作，返回新的内容
        matcher.appendTail(updatedContent);
        return updatedContent.toString();
    }
}
