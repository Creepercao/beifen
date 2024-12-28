package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.User;
import com.Creepercao.Blog.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录验证
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String name, @RequestParam String password, HttpSession session) {
        User user = userService.login(name, password);
        Map<String, Object> response = new HashMap<>();
        if (user != null) {
            session.setAttribute("user", user); // 将用户信息存入会话
            session.setAttribute("isLoggedIn", true); // 设置登录状态为 true
            String token = UUID.randomUUID().toString(); // 生成一个随机 Token
            response.put("status", "success");
            response.put("message", "登录成功");
            response.put("role", user);
            response.put("uuid", user.getUuid());
            response.put("name", user.getName());
            response.put("email", user.getEmail());
            response.put("phone", user.getPhone());
            response.put("address", user.getAddress());
            response.put("avatar", user.getAvatar());
            response.put("token", token); // 返回 Token
        } else {
            response.put("status", "fail");
            response.put("message", "用户名或密码错误");
            session.setAttribute("isLoggedIn", false); // 设置登录状态为 false
        }
        return response;
    }

    // 验证是否已登录
    @GetMapping("/isLoggedIn")
    public boolean isLoggedIn(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn"); // 获取登录状态
        return isLoggedIn != null && isLoggedIn; // 如果是 null 或 false，返回 false
    }

    // 用户登出
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 清除会话
        return "登出成功";
    }

    // 获取所有用户
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 根据ID获取用户
    @GetMapping("/{uuid}")
    public Optional<User> getUserById(@PathVariable Integer uuid) {
        return userService.getUserById(uuid);
    }

    // 创建或更新用户
    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        // 如果前端提交了密码字段，应该忽略它
        if (user.getPassword() != null) {
            user.setPassword(null); // 忽略密码字段
        }

        return userService.saveUser(user); // 只保存更新的字段
    }


    // 删除用户
    @DeleteMapping("/{uuid}")
    public void deleteUser(@PathVariable Integer uuid) {
        userService.deleteUser(uuid);
    }

    // 根据用户名过滤用户
    @GetMapping("/filter")
    public List<User> filterUsersByName(@RequestParam String name) {
        return userService.filterUsersByName(name);
    }

    // 根据邮箱获取用户
    @GetMapping("/email")
    public List<User> getUsersByEmail(@RequestParam String email) {
        return userService.getUsersByEmail(email);
    }

    // 检查用户名是否存在
    @GetMapping("/exists/name")
    public boolean checkUserNameExists(@RequestParam String name) {
        return userService.checkUserNameExists(name);
    }

    @PutMapping("/changePassword")
    public Map<String, Object> changePassword(@RequestParam String oldPassword, @RequestParam String newPassword, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        User user = (User) session.getAttribute("user"); // 获取当前登录的用户

        if (user == null) {
            response.put("status", "fail");
            response.put("message", "用户未登录");
            return response;
        }

        boolean isPasswordValid = userService.checkOldPassword(user.getUuid(), oldPassword);
        if (!isPasswordValid) {
            response.put("status", "fail");
            response.put("message", "旧密码错误");
            return response;
        }

        // 更新密码
        userService.updatePassword(user.getUuid(), newPassword);

        response.put("status", "success");
        response.put("message", "密码更新成功");
        return response;
    }

    // 检查邮箱是否已使用
    @GetMapping("/exists/email")
    public boolean checkEmailExists(@RequestParam String email) {
        return userService.checkEmailExists(email);
    }
}
