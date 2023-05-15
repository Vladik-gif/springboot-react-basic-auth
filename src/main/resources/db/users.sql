create table users(
    id       bigserial primary key,
    active   boolean not null,
    password varchar(255),
    roles    varchar(255),
    username varchar(255)
);