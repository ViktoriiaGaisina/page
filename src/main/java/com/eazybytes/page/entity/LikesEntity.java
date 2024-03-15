package com.eazybytes.page.entity;

import javax.persistence.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "likes")
public class LikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id_pk")
    private Long likeId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id_fk")
    private PostsEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coment_id_fk")
    private ComentEntity coment;

}
