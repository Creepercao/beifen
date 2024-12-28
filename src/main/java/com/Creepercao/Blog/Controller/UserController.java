package com.Creepercao.Blog.Controller;

import com.Creepercao.Blog.Entity.PasswordChangeRequest;
import com.Creepercao.Blog.Entity.User;
import com.Creepercao.Blog.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录验证
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam Integer Useruuid, @RequestParam String password, HttpSession session) {
        User user = userService.login(Useruuid, password);
        Map<String, Object> response = new HashMap<>();
        if (user != null) {
            session.setAttribute("user", user); // 将用户信息存入会话
            session.setAttribute("isLoggedIn", true); // 设置登录状态为 true
            String token = UUID.randomUUID().toString(); // 生成一个随机 Token
            response.put("status", "success");
            response.put("message", "登录成功");
            response.put("role", user.getRole());
            response.put("uuid", user.getUuid());
            response.put("email",user.getEmail());
            response.put("name", user.getName());
            response.put("avatar", user.getAvatar());
            response.put("register", user.getRegister());
            response.put("phone", user.getPhone());
            response.put("address", user.getAddress());
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

    // 获取当前登录用户信息
    @GetMapping("/me")
    public User getCurrentUser(HttpSession session) {
        // 假设已登录的用户信息存储在 session 中
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("用户未登录");
        }
    }
    // 更新用户信息
    @PostMapping("/update")
    public User updateUser(@RequestBody User updatedUser, HttpSession session) {
        // 获取当前登录的用户
        User currentUser = (User) session.getAttribute("user");
        if (currentUser != null) {
            // 更新当前用户的信息
            currentUser.setName(updatedUser.getName());
            currentUser.setEmail(updatedUser.getEmail());
            currentUser.setPhone(updatedUser.getPhone());
            currentUser.setAddress(updatedUser.getAddress());
            // 保存更新后的用户
            userService.saveUser(currentUser);
            return currentUser;
        } else {
            throw new RuntimeException("用户未登录");
        }
    }
    // 修改密码
    @PutMapping("/changePassword")
    public Map<String, String> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest, HttpSession session) {
        // 创建返回结果
        Map<String, String> response = new HashMap<>();

        // 获取当前登录的用户
        User currentUser = (User) session.getAttribute("user");
        if (currentUser != null) {
            // 检查旧密码是否正确
            if (currentUser.getPassword().equals(passwordChangeRequest.getOldPassword())) {
                // 如果旧密码正确，更新密码
                currentUser.setPassword(passwordChangeRequest.getNewPassword());
                userService.saveUser(currentUser);

                response.put("status", "success");
                response.put("message", "密码修改成功");
            } else {
                response.put("status", "error");
                response.put("message", "旧密码错误");
            }
        } else {
            response.put("status", "error");
            response.put("message", "用户未登录");
        }

        return response;
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

    // 检查邮箱是否已使用
    @GetMapping("/exists/email")
    public boolean checkEmailExists(@RequestParam String email) {
        return userService.checkEmailExists(email);
    }
    // 用户注册
    @PostMapping("/save")
    public Map<String, Object> registerUser(@RequestBody User newUser) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 检查邮箱是否已被使用
            if (userService.checkEmailExists(newUser.getEmail())) {
                response.put("status", "fail");
                response.put("message", "邮箱已被注册");
                return response;
            }

            // 设置其他默认信息
            newUser.setRole(0); // 默认角色（非管理员）
            newUser.setRegister(LocalDateTime.now()); // 设置注册时间
            // 保存用户
            userService.saveUser(newUser);  // 保存用户，uuid由数据库自增生成

            // 返回成功消息，不返回uuid
            response.put("status", "success");
            response.put("message", "注册成功");
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "注册失败，请稍后再试");
            e.printStackTrace();
        }
        return response;
    }

    // 新接口：根据邮箱获取用户UUID
    @GetMapping("/getUUID")
    public Map<String, Object> getUUIDByEmail(@RequestParam String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userService.getUserByEmail(email);
            if (user != null) {
                response.put("status", "success");
                response.put("uuid", user.getUuid());
            } else {
                response.put("status", "fail");
                response.put("message", "用户未找到");
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "查询失败，请稍后再试");
        }
        return response;
    }



}
