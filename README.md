# Baseball Project 
## Springboot + JPA + MySQL(pivot, rownum, outerjoin)

## 의존성 추가 
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Mustache
- Spring Web

#### 1. MySQL 데이터베이스 및 사용자 생성
```sql
create user 'baseball'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON 별.별 TO 'baseball'@'%';
create database baseball;
use baseball;
```

#### 2. application.yml 설정
```yml
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: UTF-8
      enabled: true
      force: true
    
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/baseball?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true
    username: baseball
    password: bitc5600
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update 
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true
```

