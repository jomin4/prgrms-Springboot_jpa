# 2~3강 — 프로젝트 세팅

## 🧠 머릿속 그림
4개 파일 → Gradle 빌드 → `main()` → 8080 기동.
```
build.gradle.kts (재료: 플러그인·의존성)  ┐
settings.gradle.kts (이름 = back)        ┘→ Gradle 읽기·컴파일
BackApplication.java  main() @SpringBootApplication → 컨테이너 부팅 → Tomcat :8080
application.yaml → 실행 설정 주입 (지금은 앱 이름)
```

## 📌 핵심 내용
- **build.gradle.kts**: Spring Boot 4.0.6 플러그인 + `dependency-management`(버전 자동). 의존성 = data-jpa·webmvc·h2·lombok·devtools·h2console. 접두어 의미: `implementation`(컴파일+실행) / `runtimeOnly`(실행만, h2) / `compileOnly`+`annotationProcessor`(lombok) / `developmentOnly`(devtools).
- **settings.gradle.kts**: `rootProject.name = "back"`.
- **application.yaml**: `spring.application.name: back`.
- **BackApplication.java**: `@SpringBootApplication` 한 줄 = 자동설정+컴포넌트스캔+설정등록. `SpringApplication.run()`이 부팅 스위치.
- Java 25 toolchain, `mavenCentral()`.

## 🔍 디버깅 정리 (실제 기동 값)
`./gradlew bootRun` 실제 로그:
- `Starting BackApplication using Java 25.0.3 with PID 22428`
- `H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:6b83de92-...'`
- `Tomcat started on port 8080 (http) with context path '/'`
- `Started BackApplication in 6.045 seconds`
→ 그림의 4상자가 실제 로그 4줄로 1:1 확인됨. DB 설정을 안 줬는데도 H2 인메모리가 자동 잡힘(→ 5강에서 다룸).

## ✅ 완료 상태
- 완료. 빌드 성공 + bootRun 8080 기동 검증. 커밋 `2~3강: 프로젝트 세팅`.
