# 4강 — 스프링 부트 첫 실행 해부 (개념, 코드 변경 없음)

## 🧠 머릿속 그림
`com.h2database:h2` 하나 = **3 in 1**
```
        com.h2database:h2
       ┌──────┼──────┐
   ①DB엔진  ②JDBC드라이버  ③웹콘솔
  mem:...   org.h2.Driver  /h2-console
```

## 📌 핵심 내용
- **h2 라이브러리의 3가지 역할:** ① DB 엔진(인메모리/파일) ② JDBC 드라이버(org.h2.Driver = 1강의 "구현체") ③ 웹 콘솔(/h2-console).
- **DB 설정 없이도 실행되는 이유:** classpath에 h2가 있고 `spring.datasource`가 없으면 스프링 부트가 **인메모리 H2를 자동 생성**(auto-config) → 로그에 랜덤 UUID DB. (5강에서 파일모드로 고정)
- **localhost:8080 접속:** 컨트롤러가 없어 `Whitelabel Error Page`(404) — 정상. 이 강의는 웹 화면이 아니라 JPA/DB가 목표.
- **8080 포트 충돌 시:** `application.yaml`에 `server.port: 8081`.

## 🔍 디버깅 정리 (실제 값 — 2~3강 bootRun 로그 재사용)
- `Database available at 'jdbc:h2:mem:6b83de92-...'` → 역할①, 자동 생성된 인메모리 DB.
- `Tomcat started on port 8080` → 서버는 살아있음(접속시 404는 페이지 부재 때문).
- `H2 console available at '/h2-console'` → 역할③.

## ✅ 완료 상태
- 완료(개념). 코드 변경 없음. 다음 5강에서 datasource 파일모드 설정 추가.
