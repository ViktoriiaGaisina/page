create table if not exists coment(
coment_id_pk serial primary key,
name varchar,
posts_id_fk int references posts(posts_id_pk)

)