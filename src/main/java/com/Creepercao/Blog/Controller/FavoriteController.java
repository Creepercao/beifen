package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 添加或取消收藏
    @PostMapping("/user/{uuid}/article/{aid}")
    public ResponseEntity<String> toggleFavorite(@PathVariable Integer uuid, @PathVariable Integer aid, @RequestBody Map<String, Boolean> request) {
        // 获取请求体中的 isFavorited 标识（true: 添加收藏，false: 取消收藏）
        boolean isFavorited = request.get("isFavorited");

        try {
            if (isFavorited) {
                // 如果 isFavorited 为 true，添加收藏
                favoriteService.addFavorite(uuid, aid);
                return ResponseEntity.ok("收藏成功");
            } else {
                // 如果 isFavorited 为 false，取消收藏
                favoriteService.removeFavorite(uuid, aid);
                return ResponseEntity.ok("取消收藏成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("收藏操作失败: " + e.getMessage());
        }
    }

    // 获取某个用户所有收藏的文章
    @GetMapping("/user/{uuid}")
    public ResponseEntity<?> getUserFavorites(@PathVariable Integer uuid) {
        try {
            return ResponseEntity.ok(favoriteService.getFavoritesByUser(uuid));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("获取收藏失败: " + e.getMessage());
        }
    }

    // 判断某个用户是否收藏某篇文章
    @GetMapping("/user/{uuid}/article/{aid}")
    public ResponseEntity<Boolean> isFavorited(@PathVariable Integer uuid, @PathVariable Integer aid) {
        try {
            boolean favorited = favoriteService.isFavorited(uuid, aid);
            return ResponseEntity.ok(favorited);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(false);
        }
    }

    // 用户添加收藏
    @PostMapping("/user/{uuid}/article/{aid}/add")
    public ResponseEntity<String> addFavorite(@PathVariable Integer uuid, @PathVariable Integer aid) {
        try {
            favoriteService.addFavorite(uuid, aid);
            return ResponseEntity.ok("添加收藏成功");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("添加收藏失败: " + e.getMessage());
        }
    }

    // 用户删除收藏
    @DeleteMapping("/user/{uuid}/article/{aid}/remove")
    public ResponseEntity<String> removeFavorite(@PathVariable Integer uuid, @PathVariable Integer aid) {
        try {
            favoriteService.removeFavorite(uuid, aid);
            return ResponseEntity.ok("删除收藏成功");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("删除收藏失败: " + e.getMessage());
        }
    }
}
