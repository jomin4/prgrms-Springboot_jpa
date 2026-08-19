# 11~12강 — 첫 데이터 저장 (save)

## 🧠 머릿속 그림
```
if (count() > 0) return;          ← 중복 초기화 방지 가드
new Post()  {id:0, title:null}
  .setTitle("제목 1")  {id:0, title:"제목 1"}
  save(post) ──Hibernate──▶ insert into post ... ──▶ DB row {id:1, title:"제목 1"}
(제목 2도 동일 → id:2)
```

## 📌 핵심 내용
- `BaseInitData`의 ApplicationRunner 안에서:
  - `if (postRepository.count() > 0) return;` — 이미 데이터 있으면 스킵(재시작마다 중복 저장 방지).
  - `Post post1 = new Post(); post1.setTitle("제목 1"); postRepository.save(post1);` (제목 2도 동일).
- **new 객체 ≠ DB 데이터**: `save()` 호출 순간에만 insert 발생.
- **id 자동 부여**: 코드에서 id 세팅 안 함 → `insert ... values (?, default)`의 default가 auto_increment(6강 @GeneratedValue IDENTITY). 결과 id 1, 2.

## 🔍 디버깅 정리 (실제 값)
`./gradlew bootRun` (db_dev 초기화 후) 콘솔:
```
Hibernate: select count(*) from post p1_0            (가드 → 0)
Hibernate: insert into post (title,id) values (?,default)   (제목 1)
Hibernate: insert into post (title,id) values (?,default)   (제목 2)
```
- `?` = title 바인딩 값, `id=default` → DB가 1,2 자동 부여.
- 재실행 시 count>0이라 가드에서 return → insert 안 나감(중복 방지 동작 확인).

## ✅ 완료 상태
- 완료. save() → insert SQL 2건 검증. 커밋 `11~12강: save로 첫 데이터 저장`.
