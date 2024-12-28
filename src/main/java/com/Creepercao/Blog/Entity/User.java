package com.Creepercao.Blog.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity // 标注为 JPA 实体类
@Table(name = "user") // 对应数据库表名
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增策略
    @Column(name = "UUID") // 对应数据库中的列名
    private Integer uuid;

    @Column(nullable = false, length = 255) // 非空字段，最大长度 255
    private String name;

    @Column(nullable = true, length = 255) // 可空字段，最大长度 255
    private String email;

    @Column(nullable = true, length = 255) // 可空字段，最大长度 255
    private String phone;

    @Column(nullable = true, length = 255) // 可空字段，最大长度 255
    private String address;

    @Column(name = "register", columnDefinition = "DATETIME") // 非空字段
    private LocalDateTime register;

    @Column(nullable = true, length = 255) // 可空字段，最大长度 255，默认值为 null
    private String password;

    @Column(nullable = true, length = 255, columnDefinition = "varchar(255) default 'src/main/resources/img/defaut.png'")
    private String avatar;

    @Column
    private Integer role;
    // 无参构造器（JPA 要求）
    public User() {
    }

    // 全参构造器
    public User(String name, String email, String phone, String address, LocalDateTime register, String password, String avatar) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.register = register;
        this.password = password;
        this.avatar = avatar;
    }

    // Getter 和 Setter 方法
    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegister() {
        return register;
    }

    public void setRegister(LocalDateTime register) {
        this.register = register;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", register=" + register +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }
}
