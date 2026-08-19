# 16~17강 — 엔티티에 content 필드 추가 (TEXT 컬럼)

## 🧠 머릿속 그림
```
Post {
  int id;
  String title;    → varchar(255)
  @Column(columnDefinition="TEXT")
  String content;  → TEXT (신규)
}
      │ ddl-auto: update (엔티티 vs 테이블 차이만 반영)
      ▼
alter table if exists post add column content TEXT   (기존 데이터 유지)
```

## 📌 핵심 내용
- Post에 `private String content;` 추가. 16강: `ddl-auto` create→update 복귀. 17강: `@Column(columnDefinition="TEXT")`.
- **엔티티 = 스키마 정답지**: 필드 추가 → update가 부족한 컬럼만 `alter table add column`.
- **String 기본 매핑 = varchar(255)**. 본문처럼 긴 글은 부족 → `columnDefinition="TEXT"`로 DB 타입 직접 지정.
- `create`(통째 재생성=데이터 소멸) vs `update`(증분=데이터 유지). 데이터 지키려 update.

## 🔍 디버깅 정리 (실제 값)
`./gradlew bootRun` (db_dev 유지, 기존 title-only 스키마 + 2행) 콘솔:
```
alter table if exists post
   add column content TEXT
```
- 테이블 재생성 없이 컬럼만 추가됨 → 기존 2행 유지, content는 NULL.
- 가드(count>0)로 insert 안 나감(중복 방지 정상).

## ✅ 완료 상태
- 완료. 엔티티 필드 추가 → alter table 자동 반영 검증. 커밋 `16~17강: content 필드·TEXT 컬럼`.
