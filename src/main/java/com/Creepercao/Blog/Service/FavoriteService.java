package com.Creepercao.Blog.Service;

import com.Creepercao.Blog.Entity.Favorite;
import com.Creepercao.Blog.dao.FavoriteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    // 获取用户的所有收藏
    public List<Favorite> getFavoritesByUser(Integer uuid) {
        return favoriteRepository.findByUuid(uuid);
    }

    // 判断用户是否收藏了某篇文章
    public boolean isFavorited(Integer uuid, Integer aid) {
        return favoriteRepository.existsByUuidAndAid(uuid, aid);
    }

    // 添加收藏
    public void addFavorite(Integer uuid, Integer aid) {
        if (!isFavorited(uuid, aid)) {
            Favorite favorite = new Favorite();
            favorite.setUuid(uuid);
            favorite.setAid(aid);
            favoriteRepository.save(favorite);
        }
    }


    // 删除收藏
    @Transactional
    public void removeFavorite(Integer uuid, Integer aid) {
        favoriteRepository.deleteByUuidAndAid(uuid, aid);
    }
}
