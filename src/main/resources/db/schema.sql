-- drop scripts


drop table if exists authority cascade;

drop table if exists client cascade;

drop table if exists client_roles cascade;

drop table if exists customer cascade;

drop table if exists role cascade;


-- create scripts


create table authority (
    is_active boolean default true not null,
    id bigint not null,
    name varchar(255) not null unique,
    primary key (id)
);

create table client (
    is_active boolean default true not null,
    created_at timestamp default current_timestamp not null,
    id bigint not null,
    address varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null unique,
    primary key (id)
);

create table client_roles (
    client_id bigint not null,
    role_id bigint not null,
    primary key (client_id, role_id)
);

create table customer (
    is_active boolean default true not null,
    authority_id bigint not null,
    created_at timestamp default current_timestamp not null,
    id bigint not null,
    name varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null unique,
    primary key (id)
);

create table role (
    is_active boolean default true not null,
    id bigint not null,
    name varchar(255) unique,
    primary key (id)
);


-- alter scripts

alter table if exists client_roles
    add constraint client_roles_role_id
    foreign key (role_id)
    references role;

alter table if exists client_roles
    add constraint client_roles_client_id
    foreign key (client_id)
    references client;

alter table if exists customer
    add constraint customer_authority_id
    foreign key (authority_id)
    references authority;
