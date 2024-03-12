create table if not exists likes(
likes_id_pk serial primary key,
name varchar,
posts_id_fk int references posts(posts_id_pk),
coment_id_fk int references coment(coment_id_pk)
)