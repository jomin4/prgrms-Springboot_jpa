# 1강 — Spring Data JPA란 · JPA에서 MySQL까지의 흐름

## 🧠 머릿속 그림
6층 계층 스택. 위에서 아래로 호출이 흐른다:

```
[내 코드 → Spring Data JPA]   ← 우리가 만지는 유일한 칸 (interface만 선언)
        ↓
   [JPA API]                  ← 자바 표준 규격
        ↓
   [Hibernate]                ← JPA 구현체 (객체 ↔ SQL 번역)
        ↓
   [JDBC API]                 ← 자바↔DB 연결 표준 규격
        ↓
   [MySQL JDBC Driver]        ← JDBC 구현체 (실제 통신)
        ↓
   [MySQL DB]                 ← 진짜 데이터 저장소
```

## 📌 핵심 내용
- **규격(API) vs 구현체** 구분이 뼈대: JPA API↔Hibernate, JDBC API↔MySQL Driver.
- 규격 = "이런 기능이 있어야 한다"는 약속 / 구현체 = 그 약속을 실제로 실행하는 코드.
- 우리는 맨 위 한 칸(Spring Data JPA)만 쓰고 아래 번역·통신은 전부 자동.
- Hibernate/JDBC를 직접 안 쓰는 이유: 반복 제거, DB 교체 자유, 트랜잭션 등 부가기능, 테스트 용이.

## 🔍 디버깅 정리
- 개념 강의라 실행 값 추적 없음. (코드 실습은 2강부터)

## ✅ 완료 상태
- 완료. "JPA = 개발자가 DB를 쉽게 다루게 해주는 자바 라이브러리" 한 문장으로 정리됨.
