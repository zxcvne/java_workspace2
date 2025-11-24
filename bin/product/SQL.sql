-- DB 설정 구문
-- DB 생성
create database javadb;

use mysql;

-- user 생성
create user 'javaUser'@'localhost' identified by 'mysql';

-- 유저 권한 부여
grant all privileges on javadb.* to 'javaUser'@'localhost';
flush privileges;

-- javaUser 접속
use javadb;

-- text : 컨텐츠 저장시 사용하는 데이터베이스 문자 타입
create table product(
pno int not null auto_increment,
pname varchar(100) not null,
price int default 0,
regdate datetime default now(),
madeby text,
primary key(pno)
);

