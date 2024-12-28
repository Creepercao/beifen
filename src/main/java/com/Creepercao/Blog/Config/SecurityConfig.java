//package com.Creepercao.Blog.Config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests()  // 使用新的 authorizeHttpRequests() 方法
//                .requestMatchers("/#/login", "/#/home", "/#/Year", "/#/article").permitAll()  // 公开页面
//                .anyRequest().authenticated()  // 其他所有请求都需要认证
//                .and()
//                .formLogin()
//                .loginPage("/#/login")  // 自定义登录页面
//                .loginProcessingUrl("/login")  // 登录请求的处理URL
//                .defaultSuccessUrl("/", true)  // 登录成功后跳转到首页
//                .permitAll()
//                .failureUrl("/#/login?error=true")  // 登录失败后跳转到登录页面
//                .and()
//                .logout()
//                .logoutUrl("/logout")  // 注销请求的URL
//                .logoutSuccessUrl("/#/login")  // 注销成功后跳转到登录页面
//                .and()
//                .csrf().disable();  // 禁用CSRF（如果是SPA应用，通常禁用）
//    }
//}
