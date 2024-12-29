package com.Creepercao.Blog.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="favorite")
public class Favorite {
    @Id
    @Column
    private Integer aid;

    @Id
    @Column
    private Integer uuid;

    @Override
    public String toString() {
        return "favorite{" +
                "aid=" + aid +
                ", uuid=" + uuid +
                '}';
    }
}
