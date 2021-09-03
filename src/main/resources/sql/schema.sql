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

drop table if exists `user`;
create table if not exists `user`(
    `user_id`       VARCHAR(50),
    `password`      VARCHAR(50),
    `email`         VARCHAR(50),
    `unique_id`     VARCHAR(50)
);