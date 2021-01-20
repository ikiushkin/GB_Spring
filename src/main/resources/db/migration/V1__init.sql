CREATE TABLE `product_tbl`
(
    `product_id` bigint(15)   NOT NULL AUTO_INCREMENT,
    `title_fld`  varchar(255) NOT NULL,
    `cost_fld`   int(11)   DEFAULT NULL,
    `created_at` timestamp default current_timestamp,
    `updated_at` timestamp default current_timestamp,

    PRIMARY KEY (`product_id`)
);
insert into product_tbl (title_fld, cost_fld)
values ('Boots', 5499),
       ('Hat', 1499),
       ('Bag', 1459),
       ('Cookies', 199),
       ('Phone', 15499),
       ('Tomato', 199),
       ('Sausage', 299),
       ('Herring', 299),
       ('Asparagus', 199),
       ('Berry', 199),
       ('apple', 99),
       ('Tea', 59),
       ('Water', 49),
       ('Beer', 129),
       ('Liqueur', 499),
       ('Burger', 159),
       ('Grill', 299),
       ('Tempura', 139),
       ('Noodles', 239),
       ('Car', 18954),
       ('Cheese', 189),
       ('Bread', 89),
       ('Tomato', 149),
       ('Potato', 49),
       ('Cabbage', 139),
       ('Rice', 99),
       ('Goulash', 339);


