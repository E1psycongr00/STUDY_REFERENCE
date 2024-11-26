# Gradle 학습 프로젝트

이 프로젝트는 Gradle 빌드 도구의 주요 개념과 기능을 학습하기 위한 예제 프로젝트입니다.

## 빌드 구성

### 플러그인

- `application`: Java 애플리케이션 빌드 및 실행을 위한 플러그인
- `org.barfuin.gradle.taskinfo`: Gradle 태스크 정보 확인을 위한 플러그인

### 의존성

```kotlin
dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.guava)
}
```

### Java 설정

- Java 21 사용
- 메인 클래스: `gradle_project.App`

## Gradle 생명주기 데모

이 프로젝트는 Gradle의 구성 단계(Configuration Phase)와 실행 단계(Execution Phase)를 이해하기 위한 두 개의 태스크를 포함하고 있습니다.

### 태스크 실행 순서

1. 구성 단계 출력:
   - "BUILD SCRIPT: This is executed during the configuration phase"
   - "REGISTER TASK1/TASK2: This is executed during the configuration phase"
   - "NAMED TASK1/TASK2: This is executed during the configuration phase"

2. 실행 단계 출력:
   - "TASK1/TASK2 - doFirst: This is executed during the execution phase"
   - "TASK1/TASK2 - doLast: This is executed during the execution phase"

## 프로젝트 실행

### 빌드 및 실행

```bash
# 프로젝트 빌드
./gradlew build

# 애플리케이션 실행
./gradlew run

# 테스트 실행
./gradlew test

# Gradle 생명주기 데모 실행
./gradlew task1 task2
```

## 의존성 버전 관리

의존성 버전은 `gradle/libs.versions.toml` 파일에서 중앙 관리됩니다:

- JUnit Jupiter: 5.10.2
- Guava: 33.0.0-jre