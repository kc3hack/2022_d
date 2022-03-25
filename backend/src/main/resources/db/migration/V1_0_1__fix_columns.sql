alter table "user"
alter column password type varchar(255) using password::varchar(255);

alter table "user"
drop column is_deleted;

