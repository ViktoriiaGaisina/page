create table if not exists posts(
posts_id_pk serial primary key,
name varchar,
users_id_fk int references users(users_id_pk)
)