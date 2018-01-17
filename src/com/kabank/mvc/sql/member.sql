select * from member;
select * from bank;
select * from tab;
delete from member whwere id ='%s';
desc member;
update member set name = '김만호' where id = 'jmh3360';

select * from member where id like ?;

insert into member(id,pass,name,ssn,phone,email) values('jmh3360','123','장만호','911123-1187511','010-5604-1198','jmh3360@naver.com');