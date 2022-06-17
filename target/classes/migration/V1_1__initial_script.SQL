create table m_users
(
    id bigserial not null
        constraint m_users_pk
            primary key,
    username varchar(200) default 'DEFAULT_NAME'::character varying not null,
    surname varchar(1000) default 'DEFAULT_SURNAME'::character varying not null,
    birth_date date not null,
    gender varchar(50) default 'NOT_SELECTED'::character varying,
    login varchar(100) default 'login'::character varying not null,
    password varchar(100) default 'password'::character varying,
    passport varchar(9) not null,
    car_n bigint,
    e_mail varchar(30),
    phone varchar(15)
);

alter table m_users owner to postgres;

create unique index m_users_login_uindex
	on m_users (login);

create unique index m_users_passport_uindex
	on m_users (passport);

create table m_auto_dealer
(
    id bigserial not null
        constraint m_auto_dealer_pk
            primary key,
    name varchar(100) not null,
    address varchar(1000) not null,
    capacity integer default 3 not null,
    created timestamp(6) not null,
    changed timestamp(6) not null,
    year_of_foundation date not null
);

alter table m_auto_dealer owner to postgres;

create index m_auto_dealer_address_index
	on m_auto_dealer (address);

create index m_auto_dealer_name_index
	on m_auto_dealer (name);

create table m_cars
(
    id bigserial not null
        constraint m_cars_pk
            primary key,
    model varchar(100) default 'model'::character varying not null,
    guarantee_expiration_date date,
    price_rent double precision not null,
    color varchar(20),
    creation date,
    capacity_l double precision,
    country_of_creation varchar(20),
    brand varchar(20) default 'DEFAULT_BRAND'::character varying not null,
    rent boolean
);

alter table m_cars owner to postgres;

create unique index m_cars_model_uindex
	on m_cars (model);

create table m_good
(
    id bigserial not null
        constraint m_good_pk
            primary key,
    good_name varchar(100) not null
);

alter table m_good owner to postgres;

create table l_user_goods
(
    id bigserial not null
        constraint l_user_goods_pk
            primary key,
    user_id integer not null
        constraint l_user_goods_m_users_id_fk
            references m_users
            on update cascade on delete cascade,
    good_id integer not null
        constraint l_user_goods_m_good_id_fk
            references m_good,
    count integer not null,
    created timestamp(6) not null,
    changed timestamp(6) not null
);

alter table l_user_goods owner to postgres;

create index l_user_goods_count_index
	on l_user_goods (count desc);

create index l_user_goods_created_index
	on l_user_goods (created desc);

create table user_role
(
    id serial not null
        constraint m_roles_pk
            primary key,
    role_name varchar(100) default 'ROLE_USER'::character varying not null,
    user_id bigint not null
        constraint m_roles_m_users_id_fk
            references m_users
            on delete cascade
);

alter table user_role owner to postgres;

create index m_roles_role_name_index
	on user_role (role_name);

create table m_contract
(
    user_id bigint
        constraint contract_id_users_fk
            references m_users,
    car_id bigint
        constraint m_contract_m_cars_id_fk
            references m_cars
            on update set null on delete cascade,
    id bigserial not null
        constraint m_contract_pk
            primary key,
    name_contract varchar(40),
    time_rent_start varchar(40),
    time_rent_end varchar(40)
);

alter table m_contract owner to postgres;

create table flyway_schema_history
(
    installed_rank integer not null
        constraint flyway_schema_history_pk
            primary key,
    version varchar(50),
    description varchar(200) not null,
    type varchar(20) not null,
    script varchar(1000) not null,
    checksum integer,
    installed_by varchar(100) not null,
    installed_on timestamp default now() not null,
    execution_time integer not null,
    success boolean not null
);

alter table flyway_schema_history owner to postgres;

create index flyway_schema_history_s_idx
	on flyway_schema_history (success);

create table m_accident
(
    id bigserial not null
        constraint m_accident_pk
            primary key,
    damages varchar(100) not null,
    data_accident varchar(10) not null,
    price_damages double precision not null,
    contract_id bigint not null
        constraint m_accident_m_contract_id_fk
            references m_contract
);

alter table m_accident owner to postgres;

create unique index m_accident_id_uindex
	on m_accident (id);

