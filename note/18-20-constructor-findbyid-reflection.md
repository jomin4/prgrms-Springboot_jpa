# 18~20강 — 생성자 · findById 조회 · JPA 기본생성자 필수

## 🧠 머릿속 그림
```
work2: findById(1)
  DB row(id=1,제목1,내용1) --select--> Hibernate 복원
    ① new Post()  (리플렉션, no-arg 생성자 호출) → 빈 객체
    ② setId/Title/Content → 값 채움
  → Optional<Post>.get() → post1 → @ToString 출력
⚠ no-arg 생성자 없으면 ①에서 실패 (No default constructor)
```

## 📌 핵심 내용
- **18강**: Post 필드 final + `@RequiredArgsConstructor` → `Post(title, content)` 생성. BaseInitData: `save(new Post("제목 1","내용 1"))`, save는 저장된 엔티티 반환.
- **19강**: 람다를 `work1()`(생성)·`work2()`(조회)로 분리. `findById(1)` → `Optional<Post>` → `select * from post where id=1`.
- **20강**: `@ToString` 추가, `opPost1.get()`으로 꺼내 출력. **기본 생성자 `public Post(){...}` 추가**.
- **JPA 기본생성자 필수(리플렉션)**: Hibernate가 DB행→객체 복원 시 no-arg 생성자로 빈 객체를 먼저 만들고 필드를 채움. final+@RequiredArgsConstructor만 있으면 no-arg가 없어 findById에서 실패 → 그래서 no-arg 생성자 명시. save(쓰기)엔 불필요, findById(읽기)엔 필수.
- **Optional**: 결과가 없을 수도 있음을 감싼 상자. `.get()`으로 꺼냄(실무는 orElseThrow 등).

## 🔍 디버깅 정리 (실제 값)
`./gradlew bootRun` (db_dev 초기화) 콘솔:
```
insert ... binding (1:VARCHAR)<-[내용 1], (2:VARCHAR)<-[제목 1]   (×2, work1)
select ... from post where id=?  binding (1:INTEGER)<-[1]         (work2 findById)
post1 : Post(id=1, title=제목 1, content=내용 1)                   (@ToString)
```
- `No default constructor` 에러 없이 findById 성공 → 기본생성자 효과 확인.
- insert 파라미터 순서가 (content, title)로 나가는 것 관찰(엔티티 필드 순서/하이버네이트 처리).

## ✅ 완료 상태
- 완료. findById select + 기본생성자 리플렉션 검증. 커밋 `18~20강: 생성자·findById·기본생성자 필수`.
