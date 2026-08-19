# 학습 노트 — Spring Boot + JPA 기초

> 성장형 학습 프로젝트. 자료: slog.gg/p/14158 (56강). 참조 레포: jhs512/p-14158-1.
> 진행 방식/규약은 프로젝트 루트의 `CLAUDE.md` 참고.

## 진도표

| 강 | 주제 | 상태 | 노트 |
|----|------|------|------|
| 1 | Spring Data JPA란 · JPA→MySQL 흐름 (개념) | ✅ 완료 | (개념, 코드 없음) |
| 2~3 | 프로젝트 세팅 (Initializr, build.gradle, application.yaml, 메인 클래스) | ✅ 완료 | [02-03](02-03-project-setup.md) |
| 4 | 스프링 부트 첫 실행 해부 (h2 3역할·auto-config) | ✅ 완료 | [04](04-first-run.md) |
| 5 | H2 파일모드 · DB 전략 · .gitignore | ✅ 완료 | [05](05-h2-file-mode.md) |
| 6~7 | 엔티티 클래스(Post) · ddl-auto | ✅ 완료 | [06-07](06-07-entity-ddl-auto.md) |
| 8~10 | git 되돌리기 · 빈/ApplicationRunner · JpaRepository/@Autowired | ⏳ 다음 | — |
| 11~22 | save/findById · 생성자와 JPA 리플렉션 · final 필드 | ⬜ 예정 | — |
| 23~31 | @Component/@Service 계층화 | ⬜ 예정 | — |
| 32~39 | 트랜잭션 · 더티체킹 · 영속성 컨텍스트 | ⬜ 예정 | — |
| 38~40 | Auditing · BaseEntity · @MappedSuperclass | ⬜ 예정 | — |
| 41~52 | 테스트 · 롤백 · dev/test 프로파일 | ⬜ 예정 | — |
| 53~56 | 샘플 데이터 · 패러다임 불일치 마무리 | ⬜ 예정 | — |

## 범례
⬜ 예정 · ⏳ 진행중 · ✅ 완료

## 완료 로그
- 1강: JPA는 개발자가 DB를 쉽게 다루게 해주는 자바 라이브러리. "규격(API) vs 구현체" 개념 정립.
- 2~3강: 프로젝트 세팅 4파일 반영 + bootRun 8080 기동 검증 완료.
