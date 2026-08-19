package com.back.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private final String title;
    @Column(columnDefinition = "TEXT")
    private final String content;

    public Post() {
        this.title = "";
        this.content = "";
    }
}
