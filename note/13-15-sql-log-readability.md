# 13~15강 — SQL 로그 가독성 (정렬·색상·바인딩 값)

## 🧠 머릿속 그림
```
설정 전(11강):  insert into post (title,id) values (?,default)     ← 한 줄, ? 감춰짐
설정 후(15강):  /* insert for Post */
                insert
                    into post (title, id)
                    values (?, default)
                binding parameter (1:VARCHAR) <- [제목 1]           ← 실제 값!
```

## 📌 핵심 내용 (설정 → 효과)
- `spring.jpa.properties.hibernate.format_sql: true` → SQL 여러 줄 정렬.
- `…use_sql_comments: true` → `/* insert for ... */` 주석(무슨 작업인지).
- `…highlight_sql: true` → SQL 키워드 색상.
- `spring.output.ansi.enabled: always` (14강) → 콘솔 ANSI 색상 강제 ON.
- `logging.level.org.hibernate.orm.jdbc.bind: TRACE` (15강) → `?`에 바인딩된 실제 값 출력. (extract: TRACE = 조회 결과값)
- 전제: `spring.jpa.show-sql: true` (SQL 콘솔 출력 스위치).
- 이 슬라이스에서 ddl-auto는 13강 기준 `create`(16강에서 update로 복귀).

## 🔍 디버깅 정리 (실제 값)
`./gradlew bootRun` (db_dev 초기화 후) 콘솔:
```
/* insert ... */ insert into post ... values (?, default)
TRACE org.hibernate.orm.jdbc.bind : binding parameter (1:VARCHAR) <- [제목 1]
TRACE org.hibernate.orm.jdbc.bind : binding parameter (1:VARCHAR) <- [제목 2]
```
- 11강의 `?` 정체가 `[제목 1]`, `[제목 2]`로 드러남 → 실제 DB로 간 값 확인.
- format_sql로 SQL이 여러 줄 정렬됨, use_sql_comments로 `/* insert ... */` 주석 붙음.

## ✅ 완료 상태
- 완료. 바인딩 파라미터 실제 값 로그 검증. 커밋 `13~15강: SQL 로그 가독성`.
