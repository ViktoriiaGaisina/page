package com.eazybytes.page.entity;

import javax.persistence.*;
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
    @Column(name = "posts_id_pk")
    private Long postsId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id_fk")
    private UsersEntity user;

    @OneToMany(mappedBy = "post")
    private List<ComentEntity> comentList;

    @OneToMany(mappedBy = "post")
    private List<LikesEntity> likesList;
}
