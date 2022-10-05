drop database if exists typing_game;
create database typing_game;
use typing_game;

drop table if exists member;
create table member(

   mno int not null auto_increment primary key ,
   mid varchar(10),
   pw varchar(10),
   mname char(5),
   mnn char(10)
 

);

insert into member values( null,'Jooh','1234','주혁','주혁짱');
insert into member values( null ,'이종훈' , '1234' , '이종훈' , '이종훈' );
select * from member;


drop database if exists typing_game;
create database typing_game;
use typing_game;

drop table if exists member;
create table member(

   mno int not null auto_increment primary key ,
   mid varchar(10),
   pw varchar(10),
   mname char(5),
   mnn char(10)
 

);

insert into member values( null,'Jooh','1234','주혁','주혁짱');
insert into member values( null ,'이종훈' , '1234' , '이종훈' , '이종훈' );
select * from member;


drop table if exists quiz;
create table quiz(
   qno int not null auto_increment primary key ,
   qmsg varchar(10)
   
);
select * from quiz;
insert into quiz value(null,'나이아가라폭포');
insert into quiz value(null,'포켓몬스터');
insert into quiz value(null,'아이스하키');
insert into quiz value(null,'베어그릴스');
insert into quiz value(null,'디지몬어드벤처');
insert into quiz value(null,'아브라카다브라');
insert into quiz value(null,'지킬앤하이드');
insert into quiz value(null,'참치꽁치찜');
insert into quiz value(null,'경찰청창살');
insert into quiz value(null,'안양양장점');
insert into quiz value(null,'금강산도식후경');
insert into quiz value(null,'단판맛통찐빵');
insert into quiz value(null,'공간감각무감각');
insert into quiz value(null,'붕당정책탕평책');
insert into quiz value(null,'클레오파트라');
insert into quiz value(null,'셰익스피어');
insert into quiz value(null,'레오나르도다빈치');
insert into quiz value(null,'계란노른자');
insert into quiz value(null,'스팸통구이');
insert into quiz value(null,'오꼬노미야끼');
insert into quiz value(null,'아이스아메리카노');
insert into quiz value(null,'콘푸로스트');

select * from quiz;

drop table if exists score;
create table score(
   mno int ,
   ss  tinyint not null ,
   sdate datetime default now(),
   foreign key (mno) references member(mno)

);
select * from score where mno = 2 order by sdate desc;

insert into score( mno , ss ) values( null , null );

select * from member where mid = '이종훈' and pw = '1234';

select mno 회원번호 , sum(ss) 총점수 from score group by mno order by sum(ss) DESC;
select * from score s , member m where s.mno = m.mno;

select m.mnn 닉네임 , sum( s.ss ) 총점수 from score s , member m where s.mno = m.mno group by m.mnn order by sum(s.ss) desc;

select m.mnn 닉네임 , sum( s.ss ) 총점수 from score s , member m where s.mno = m.mno group by m.mnn order by sum(s.ss) desc;

select * from quiz order by rand();  -- 문제 랜덤배치



select * from score;
