package com.Creepercao.Blog.Service;

import com.Creepercao.Blog.Entity.User;
import com.Creepercao.Blog.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 获取所有用户
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 根据用户ID获取用户
    public Optional<User> getUserById(Integer uuid) {
        return userRepository.findById(uuid);
    }

    // 创建或更新用户
    public User saveUser(User user) {
        // 如果用户没有设置头像，则使用默认头像路径
        if (user.getAvatar() == null || user.getAvatar().isEmpty()) {
            user.setAvatar("/img/default.png");
        }
        if (user.getRegister() == null) {
            user.setRegister(LocalDateTime.now());
        }
        return userRepository.save(user);
    }

    // 删除用户
    public void deleteUser(Integer uuid) {
        userRepository.deleteById(uuid);
    }

    // 根据用户名过滤用户
    public List<User> filterUsersByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name); // 使用数据库查询优化
    }

    // 根据邮箱获取用户
    public List<User> getUsersByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email); // 使用数据库查询优化
    }

    // 验证用户的登录信息
    public User login(String name, String password) {
        return userRepository.findByNameAndPassword(name, password); // 使用数据库查询优化
    }

    // 检查用户名是否存在
    public boolean checkUserNameExists(String name) {
        return userRepository.existsByNameIgnoreCase(name); // 使用数据库查询优化
    }

    // 检查邮箱是否已使用
    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmailIgnoreCase(email); // 使用数据库查询优化
    }

    // 更新用户密码
    public boolean updatePassword(Integer uuid, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(uuid);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    // 根据 UUID 获取用户名
    public String getNameByUuid(Integer uuid) {
        Optional<User> userOptional = userRepository.findById(uuid);
        return userOptional.map(User::getName).orElse(null);  // 如果找不到用户，返回null
    }
}