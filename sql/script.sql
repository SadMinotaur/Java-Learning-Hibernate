DROP TABLE IF EXISTS "userbase" cascade;
DROP TABLE IF EXISTS "users" cascade;
DROP TABLE IF EXISTS "autos" cascade;

CREATE TABLE "userbase"
(
    "id"    SERIAL primary key not null,
    "login" VARCHAR unique
);


CREATE TABLE "users"
(
    "id"   INTEGER primary key references "userbase" ("id") on delete cascade on update cascade,
    "password" VARCHAR,
    "name"     VARCHAR,
    "age"      INTEGER
);

CREATE TABLE "autos"
(
    "id"      SERIAL primary key not null,
    "model"   VARCHAR,
    "color"   VARCHAR,
    "user_id" INTEGER references "users" ("id") on delete cascade on update cascade
);