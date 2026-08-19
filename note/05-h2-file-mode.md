# 5강 — H2 파일모드 & DB 전략

## 🧠 머릿속 그림
```
인메모리(4강)  jdbc:h2:mem:랜덤   → RAM만, 재시작 시 소멸
파일모드(5강)  jdbc:h2:./db_dev   → db_dev.mv.db 파일, 재시작해도 유지
                 ;MODE=MySQL       → H2가 MySQL처럼 동작
```

## 📌 핵심 내용
- `application.yaml`의 `spring.datasource` 추가:
  - `url: jdbc:h2:./db_dev;MODE=MySQL` (파일모드 + MySQL 호환)
  - `username: sa`, `password:`(빈 값), `driver-class-name: org.h2.Driver`
- **MODE=MySQL**: 실습은 H2지만 실전 MySQL과 문법 맞춤 → DB 교체 자유(1강).
- **H2 콘솔 접속**: `http://localhost:8080/h2-console`, JDBC URL `jdbc:h2:./db_dev`, User `sa`, PW 없음.
- **DB 초기화**: 서버 끄고 `db_dev.mv.db` 삭제 → 새 DB.
- **.gitignore**: `db_dev.mv.db / .trace.db / .lock.db` 제외 (로컬 데이터라 커밋 안 함).

## 🔍 디버깅 정리 (실제 값)
`./gradlew bootRun` 로그/파일:
- `Database available at 'jdbc:h2:./db_dev'` (mem 랜덤 → 고정 파일 경로로 변경 확인).
- `db_dev.mv.db` 파일 실제 생성(16384 bytes).
- `Tomcat started on port 8080`, `Started BackApplication in 6.357 seconds`.
- git status에 db_dev.* 안 뜸 (gitignore 동작 확인).

## ✅ 완료 상태
- 완료. 파일모드 전환 + 파일 생성 검증. 커밋 `5강: H2 파일모드`.
