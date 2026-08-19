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
| 8~10 | git 되돌리기 · 빈/ApplicationRunner · JpaRepository/@Autowired | ✅ 완료 | [08-10](08-10-bean-runner-repository.md) |
| 11~12 | save로 첫 데이터 저장 (insert) | ✅ 완료 | [11-12](11-12-save-insert.md) |
| 13~15 | SQL 로그 가독성 (format·color·bind 값) | ✅ 완료 | [13-15](13-15-sql-log-readability.md) |
| 16~17 | content 필드 추가 · @Column TEXT (alter table) | ✅ 완료 | [16-17](16-17-content-text-column.md) |
| 18~20 | 생성자 · findById · JPA 기본생성자 필수(리플렉션) | ✅ 완료 | [18-20](18-20-constructor-findbyid-reflection.md) |
| 21~22 | 생성자 리팩터(@NoArgsConstructor) · final 필드 리플렉션 | ⏳ 다음 | — |
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
- 4강: h2 3역할·auto-config 개념. 5강: H2 파일모드(db_dev.mv.db). 6~7강: Post 엔티티→create table 검증.
- 8~10강: PostRepository(JpaRepository) 자동 빈 + ApplicationRunner + count() → select count(*) 검증.
