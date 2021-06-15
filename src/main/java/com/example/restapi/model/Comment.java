package com.example.restapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    private long id;
    private String content;
    private LocalDateTime created;


    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> comment;

}
