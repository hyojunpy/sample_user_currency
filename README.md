# Currency_exchange(환전 요청 프로그램)

---
## 🛠️ Tools :  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=github&logoColor=Green"> <img alt="Java" src ="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"/>  <img alt="Java" src ="https://img.shields.io/badge/intellijidea-000000.svg?&style=for-the-badge&logo=intellijidea&logoColor=white"/>

---
## 👨‍💻 Period : 2024/11/28 ~ 2024/11/29

---
## 👨‍💻 ERD
![image](https://github.com/user-attachments/assets/600ece7f-e6e8-4660-b200-31e93c5f687f)

---
## 👨‍💻 API명세서
### https://documenter.getpostman.com/view/39378739/2sAYBXCB8X

---
## 👨‍💻 About Project

- 통화 환전에 대한 프로젝트이다. 통화의 id를 받아서 amountInKrw(환전 전 금액)를 환율을 적용해 환전한다. user가 삭제되었을 때 환전 요청 기록도 같이 삭제되도록 cascade 속성을 적용하였다. 
---
## 🥵 Trouble Shooting & 🚀 Refactoring
예외처리 , validation 처리 시 BigDecimal에 대한 NotBlank 적용 시 문제  
https://velog.io/@hardlife/%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-cktrivs8

---
## 😭 아쉬운점
- 예외 처리 과정에서 어떤 부분이 어디서 어떻게 작동하는지에 대한 이해도가 부족했다. 

