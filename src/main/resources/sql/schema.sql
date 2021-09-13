-- drop table if exists `pokedex`;
-- create table if not exists `pokedex`(
--     `id`            INTEGER PRIMARY KEY NOT NULL,
--     `name`          VARCHAR(30),
--     `types`         VARCHAR(100),
--     `height`        DECIMAL,
--     `weight`        DECIMAL,
--     `abilities`     VARCHAR(100),
--     `egg_groups`    VARCHAR(100),
--     `stats`         VARCHAR(200),
--     `genus`         VARCHAR(30),
--     `description`   VARCHAR(200),
--     `captured`      BIT
-- );

drop table if exists `captured_pokemon`;
create table if not exists `captured_pokemon`(
    `id`            INTEGER PRIMARY KEY NOT NULL,
    `captured`      BIT
);

drop table if exists `user`;
create table if not exists `user`(
    `user_id`       VARCHAR(50) PRIMARY KEY NOT NULL,
    `password`      VARCHAR(100),
    `email`         VARCHAR(50),
    `unique_id`     VARCHAR(50),
    `role`          VARCHAR(50)
);