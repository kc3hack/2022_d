alter table "user"
    add point int default 0 not null;

create table item
(
    id        uuid        default gen_random_uuid()
        constraint item_pk
            primary key,
    name      text                                  not null,
    category  varchar(255)                          not null,
    image     text                                  not null,
    note      varchar(255)                          not null,
    user_id   uuid                                  not null
        constraint item_user_id_fk
            references "user"
            on update cascade on delete cascade,
    update_on timestamptz,
    create_at timestamptz default current_timestamp not null,
    update_at timestamptz                           not null
);

drop table product;
