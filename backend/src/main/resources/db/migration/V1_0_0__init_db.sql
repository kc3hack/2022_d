create table "user"
(
    id         uuid                     default gen_random_uuid() not null
        constraint user_pk
            primary key,
    email      varchar(255)                                       not null,
    password   varchar(36)                                        not null,
    name       varchar(255)                                       not null,
    role       varchar(16)                                        not null,
    create_at  timestamp with time zone default CURRENT_TIMESTAMP not null,
    update_at  timestamp with time zone,
    is_deleted boolean                  default false             not null
);

create unique index user_email_uindex
    on "user" (email);

create table product
(
    id         uuid                     default gen_random_uuid() not null
        constraint product_pk
            primary key,
    name       text                                               not null,
    category   varchar(64)                                        not null,
    image      text                                               not null,
    note       text,
    user_id    uuid                                               not null
        constraint product_user_id_fk
            references "user"
            on update cascade on delete cascade,
    update_on  timestamp with time zone                           not null,
    is_deleted boolean                  default false             not null,
    update_at  timestamp with time zone,
    create_at  timestamp with time zone default CURRENT_TIMESTAMP not null
);

