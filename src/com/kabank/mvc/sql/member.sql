drop sequence <!-- 시퀀스 명을 잘못 입력하였을 때 쓴다.  -->
create sequence customer_num start with 1000;<!-- tuple생성시 마다 1씩 증가하게  -->
create table kakao(
	customer_num number primary key,
	account_num varchar2(20) not null,
	money varchar2(20) default 0,
	id varchar2(20),
	foreign key id references Member(id)
	on delete cascade );
	
	insert into kakao(customer_num,account_num,money,id)
	values(customer_num.nextval,'65465433','0',3)

select * from member;
select * from bank;
select * from tab;
delete from bank whwere id ='3';
desc member;
update member set name = '김만호' where id = 'jmh3360';

select * from member where id like ?;

insert into member(id,pass,name,ssn,phone,email) values('jmh3360','123','장만호','911123-1187511','010-5604-1198','jmh3360@naver.com');