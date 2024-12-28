package com.Creepercao.Blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.Creepercao.Blog.dao")
@EntityScan("com.Creepercao.Blog.Entity") // Ensure this points to the correct entity package
public class CreepercaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreepercaoApplication.class, args);
    }
}
