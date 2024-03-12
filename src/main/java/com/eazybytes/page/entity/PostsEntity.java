package com.eazybytes.page.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "posts")
public class PostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    private Long posid;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private UsersEntity users;

    @OneToMany(mappedBy = "posts")
    private List<ComentEntity> comentList;

    @OneToMany(mappedBy = "posts")
    private List<LikesEntity> likesList;
}
