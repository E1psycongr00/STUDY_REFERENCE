# Java 기반 유한 상태 기계(Finite State Machine) 구현

이 프로젝트는 유한 상태 기계(Finite State Machine, FSM)의 기본 개념을 학습하고 구현하기 위한 Java 기반 프레임워크입니다.

## 프로젝트 구조

### 핵심 컴포넌트

- `State`: 상태를 정의하는 인터페이스
- `Event`: 상태 변화를 트리거하는 이벤트 인터페이스
- `Transition`: 상태 전이를 담당하는 클래스
- `StateMachine`: 상태 기계의 핵심 동작을 정의하는 인터페이스
- `DefaultStateMachine`: 기본 구현체

### 주요 기능

- 상태 전이(State Transition) 정의 및 실행
- 이벤트 기반 상태 변경
- 상태 변경 시 실행되는 액션 정의
- 상태 변경 리스너를 통한 모니터링

## 예제: 주문 처리 시스템

프로젝트에는 상태 기계의 실제 사용 예시를 보여주는 주문 처리 시스템이 포함되어 있습니다.

### 구현된 상태
- CREATED (생성됨)
- PAID (결제됨)
- SHIPPED (배송중)
- DELIVERED (배송완료)
- CANCELLED (취소됨)

### 구현된 이벤트
- PAY (결제)
- SHIP (배송시작)
- DELIVER (배송완료)
- CANCEL (취소)

## 사용 예시

```java
// 상태 기계 생성
StateMachine orderStateMachine = new DefaultStateMachine(OrderState.CREATED);

// 상태 전이 정의
DefaultStateMachine machine = (DefaultStateMachine) orderStateMachine;
machine.addTransition(OrderState.CREATED, OrderState.PAID, OrderEvent.PAY);
machine.addTransition(OrderState.PAID, OrderState.SHIPPED, OrderEvent.SHIP);
machine.addTransition(OrderState.SHIPPED, OrderState.DELIVERED, OrderEvent.DELIVER);
machine.addTransition(OrderState.CREATED, OrderState.CANCELLED, OrderEvent.CANCEL);
machine.addTransition(OrderState.PAID, OrderState.CANCELLED, OrderEvent.CANCEL);

// 상태 변경 리스너 추가
machine.addStateChangeListener((from, to, event) -> 
    System.out.printf("상태 변경: %s -> %s (이벤트: %s)%n", 
        from.getName(), to.getName(), event.getName()));

// 상태 기계 시작
machine.start();
```

## 학습 포인트

이 프로젝트를 통해 다음과 같은 개념과 패턴을 학습할 수 있습니다:

1. 상태 패턴(State Pattern)의 실제 구현
2. 이벤트 기반 프로그래밍
3. 인터페이스와 구현체의 분리
4. 옵저버 패턴(리스너 구현)

## 프로젝트 확장 가능성

현재 구현된 기본 기능을 토대로 다음과 같은 기능을 추가로 구현할 수 있���니다:

1. 상태 진입/이탈 시 실행될 액션 정의
2. 가드 조건을 통한 상태 전이 제어
3. 계층적 상태 기계 구현
4. 상태 기계 영속성 지원
5. 비동기 이벤트 처리
