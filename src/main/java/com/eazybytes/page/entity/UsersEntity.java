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
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id_pk")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<PostsEntity> postsList;
}
