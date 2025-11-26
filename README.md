# java_workspace2

product

상품에 대한 DB 저장

Product class =>
pno, pname, price, regdate, madeby

DB 연결시
host localhost:3306
user javaUser
password mysql
database javadb

npm i mysql2 =>
JDBC

// 자바 라이브러리 설치 사이트
https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.0.33

## 이클립스에 대한 설정

window -> preferences
java -> Installed JRES => jdk-11 apply
java -> Compiler -> level : 11 apply and close

## 프로젝트에 대한 설정

프로젝트 폴더 우클릭
-> Properties

1. Java Build Path -> Libraries -> edit -> workspace default jdk
2. Java Compiler -> level : 11

Libraries => ClassPath => Add External JARs... => 설치한 외부라이브러리 선택

테이블
