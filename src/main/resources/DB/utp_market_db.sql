
create table category
(
    id            int auto_increment
        primary key,
    name_category varchar(100) null
);

create table offer
(
    id         int auto_increment
        primary key,
    name_offer varchar(100)  null,
    descuento  decimal(5, 2) null
);

create table product
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    description text         null,
    stock       int          null,
    coin        double       null,
    price       double       null,
    id_category int          null,
    constraint product_ibfk_1
        foreign key (id_category) references category (id)
);

create table offer_product
(
    id_offer   int not null,
    id_product int not null,
    primary key (id_offer, id_product),
    constraint offer_product_ibfk_1
        foreign key (id_offer) references offer (id),
    constraint offer_product_ibfk_2
        foreign key (id_product) references product (id)
);

create index id_product
    on offer_product (id_product);

create index id_category
    on product (id_category);

create table usuario
(
    id              int auto_increment
        primary key,
    usuario         varchar(255)                                     null,
    password        varchar(255)                                     null,
    rol             enum ('ADMIN', 'EMPLOYEE', 'STUDENT', 'TEACHER') not null,
    coin_associates double                                           null
);

create table comprobante
(
    id_comprobante int auto_increment
        primary key,
    fecha          date   not null,
    total          double not null,
    id_usuario     int    null,
    constraint fk_usuario
        foreign key (id_usuario) references usuario (id)
);

create table detalle_compra
(
    id_detalle     int auto_increment
        primary key,
    id_comprobante int        not null,
    id_producto    int        not null,
    cantidad       int        not null,
    precio_unit    double     not null,
    estado_entrega tinyint(1) null,
    estado_pago    tinyint(1) null,
    constraint detalle_compra_ibfk_1
        foreign key (id_comprobante) references comprobante (id_comprobante),
    constraint detalle_compra_ibfk_2
        foreign key (id_producto) references product (id)
);

create index id_comprobante
    on detalle_compra (id_comprobante);

create index id_producto
    on detalle_compra (id_producto);

