package com.eazybytes.page.entity;

import javax.persistence.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id_fk")
    private PostsEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coment_id_fk")
    private ComentEntity coment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="users_id_fk")
    private UsersEntity user;


}
