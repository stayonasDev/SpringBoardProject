create table board{
   id bigint auto_increment primary key,
   title varchar(255) not null,
   content text not null,
   auth_id varchar(255) not null,
   nickname varchar(255) not null,
   create_date DATETIME DEFAULT current_timestamp,
   update_date DATETIME DEFAULT current_timestamp on update current_timestamp
   );
