# Gradle 학습 프로젝트

## 프로젝트 개요

이 프로젝트는 Gradle 빌드 도구의 핵심 기능을 학습하기 위한 예제 프로젝트입니다. Java 애플리케이션을 기반으로 Gradle의 다양한 기능을 실습할 수 있도록 구성되어 있습니다.

## 주요 학습 내용

### 1. 기본 프로젝트 구조

- Gradle 멀티 프로젝트 구조
- buildSrc를 활용한 빌드 로직 모듈화
- 프로젝트 의존성 관리

### 2. 커스텀 플러그인

- Java/Kotlin DSL을 활용한 플러그인 개발
- 커스텀 Task 구현
- 플러그인 설정 및 적용

예시 코드:

```kotlin
kotlin
class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("greeting") {
            doLast {
                println("Hello, World!")
            }
        }
    }
}

apply<GreetingPlugin>()
```

### 3. 커스텀 태스크 구현

기본 커스텀 태스크 예시:

kotlin 코드:

```kotlin
open class CustomDefaultTask : DefaultTask() {
    init {
        group = "custom"
        description = "기본 커스텀 태스크 예제"
    }

    @TaskAction
    fun run() {
        println("커스텀 태스크가 실행되었습니다!")
        println("현재 프로젝트: ${project.name}")
    }
} 
```

java 코드:

```java
public class HelloTask extends DefaultTask {

    @Input
    private String message;

    public HelloTask() {
        setGroup("my-custom");
        setDescription("기본 커스텀 태스크 예제입니당!!!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @TaskAction
    void hello() {
        System.out.println(message);
    }
}
```

## 프로젝트 구조

```text
.
├── app/ # 메인 애플리케이션
├── buildSrc/ # 빌드 로직 모듈
│ └── src/main/
│ ├── kotlin/ # Kotlin으로 작성된 커스텀 태스크
│ └── java/ # Java로 작성된 커스텀 태스크
└── gradle/ # Gradle 래퍼 및 설정
```

## 시작하기

### 필수 요구사항

- JDK 21
- Gradle 8.8 이상

### 빌드 및 실행

```bash
프로젝트 빌드
./gradlew build

커스텀 태스크 실행
./gradlew helloTask
./gradlew helloMyTask
./gradlew greeting
```

## 주요 기술 스택

- Gradle 8.8
- Java 21
- Kotlin DSL
- JUnit 5
