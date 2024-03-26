create table if not exists likes(
likes_id_pk serial primary key,
coment_id_fk int references coment(coment_id_pk),
users_id_fk int references users(users_id_pk),
posts_id_fk int references posts(posts_id_pk)
)