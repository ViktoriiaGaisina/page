package com.eazybytes.page.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "coment")
public class ComentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coment_id_pk")
    private Long comentId;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id_fk")
    private PostsEntity post;

    @OneToMany(mappedBy = "coment")
    private List<LikesEntity> likesList;
}
