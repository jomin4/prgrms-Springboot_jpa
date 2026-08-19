# 8~10강 — 빈 · ApplicationRunner · JpaRepository

## 🧠 머릿속 그림
```
interface PostRepository extends JpaRepository<Post, Integer>  (선언만)
        │ 스프링이 구현 빈 자동 생성
        ▼
[스프링 컨테이너]  PostRepository 구현 빈 ──@Autowired 주입──▶ BaseInitData
                                                          @Bean ApplicationRunner
                                                            = 앱 시작시 자동 실행
                                                            println(...) + count()
                                                                     │
                                                                     ▼
                                                   Hibernate: select count(*) from post
```

## 📌 핵심 내용
- **빈(Bean)**: 스프링이 생성·관리하는 객체. `@Bean`/`@Configuration`으로 등록.
- **ApplicationRunner**: 앱 부팅 완료 직후 자동 1회 실행. 초기화 코드 자리.
- **BaseInitData** (`global/initData/`): `@Configuration` + `@Bean ApplicationRunner` 람다.
- **PostRepository** (`domain/post/post/repository/`): `extends JpaRepository<Post, Integer>` — 메서드 선언 0개인데 CRUD(count/save/findById...) 자동 제공. 제네릭 = <엔티티, PK타입>.
- **@Autowired**: 자동 생성된 리포지터리 빈을 필드에 주입(직접 new ❌).
- 8강(개념): `git checkout <커밋>` / `git reset`로 특정·최신 상태로 되돌리기. 코드 변경 없음.

## 🔍 디버깅 정리 (실제 값)
`./gradlew bootRun` 콘솔:
- `Hibernate: select count(*) from post p1_0` ← `postRepository.count()`가 만든 실제 SQL. (테이블 비어있어 결과 0)
- `System.out.println("기본 데이터가 초기화되었습니다.")`는 실행됨(뒤의 count SQL이 실행 증거). 단, 파이프 stdout 버퍼링 때문에 종료 시 캡처엔 안 잡힘 — logback SQL 로그만 즉시 flush됨.
- devtools 재시작으로 count SQL이 로그에 2번 보이는 현상 관찰.

## ✅ 완료 상태
- 완료. 리포지터리 빈 자동생성 + count() 실제 SQL 검증. 커밋 `8~10강: 빈·ApplicationRunner·JpaRepository`.
