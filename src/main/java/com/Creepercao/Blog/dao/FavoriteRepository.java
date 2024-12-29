package com.Creepercao.Blog.dao;

import com.Creepercao.Blog.Entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    // 查找用户收藏的所有文章
    List<Favorite> findByUuid(Integer uuid);

    // 查找某个用户是否收藏某篇文章
    boolean existsByUuidAndAid(Integer uuid, Integer aid);

    // 删除某个用户对某篇文章的收藏
    void deleteByUuidAndAid(Integer uuid, Integer aid);
}
