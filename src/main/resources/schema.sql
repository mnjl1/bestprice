drop table if exists hotPriceSchedule;
drop table if exists hotPriceOrder;
drop table if exists company;

  create table hotPriceSchedule(
  hotPriceScheduleId bigserial primary key,
  hotPriceStartDate date,
  hotPriceEndDate date
);

 create table hotPriceOrder(
 hotPriceOrderId bigserial primary key,
 company_name varchar (50),
 ean varchar (14),
 product_name varchar (50),
 regular_price DOUBLE PRECISION ,
 discount_price DOUBLE PRECISION ,
 created_date date,
 hotPriceScheduleId int ,
 orderStatus int,
 company_id int
);

create table company(
  company_id bigserial primary key,
  company_name varchar(100),
  email varchar(50),
  password varchar(50),
  hotPriceOrderId int
);