package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 获取用户的所有收藏
    @GetMapping("/user/{uuid}")
    public ResponseEntity<List<Integer>> getUserFavorites(@PathVariable Integer uuid) {
        List<Integer> favoriteAids = favoriteService.getFavoritesByUser(uuid).stream()
                .map(favorite -> favorite.getAid())
                .toList();
        return ResponseEntity.ok(favoriteAids);
    }

    // 判断用户是否收藏了某篇文章
    @GetMapping("/user/{uuid}/article/{aid}")
    public ResponseEntity<Boolean> isFavorited(@PathVariable Integer uuid, @PathVariable Integer aid) {
        return ResponseEntity.ok(favoriteService.isFavorited(uuid, aid));
    }

    // 用户添加收藏
    @PostMapping("/user/{uuid}/article/{aid}")
    public ResponseEntity<String> addFavorite(@PathVariable Integer uuid, @PathVariable Integer aid) {
        favoriteService.addFavorite(uuid, aid);
        return ResponseEntity.ok("收藏成功");
    }

    // 用户删除收藏
    @DeleteMapping("/user/{uuid}/article/{aid}")
    public ResponseEntity<String> removeFavorite(@PathVariable Integer uuid, @PathVariable Integer aid) {
        favoriteService.removeFavorite(uuid, aid);
        return ResponseEntity.ok("取消收藏成功");
    }
}
