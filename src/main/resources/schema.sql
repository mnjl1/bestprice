drop table if exists hotPriceSchedule;
drop table if exists hotPriceOrder;

  create table hotPriceSchedule(
  hotPriceScheduleId bigserial primary key,
  hotPriceStartDate date,
  hotPriceEndDate date
);

 create table hotPriceOrder(
 order_id bigserial primary key,
 company_name varchar (50),
 ean varchar (14),
 product_name varchar (50),
 regular_price DOUBLE PRECISION ,
 discount_price DOUBLE PRECISION ,
 hotPriceScheduleId int ,
 orderStatus int,
 created_date date
);