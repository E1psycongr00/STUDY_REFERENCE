package state_machine.example;

import state_machine.core.DefaultStateMachine;
import state_machine.core.StateMachine;

public class OrderExample {
    public static void main(String[] args) {
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
        machine.addStateChangeListener((from, to, event) -> System.out.printf("상태 변경: %s -> %s (이벤트: %s)%n",
                from.getName(), to.getName(), event.getName()));

        // 상태 기계 시작
        machine.start();

        // 이벤트 발생
        System.out.println("현재 상태: " + machine.getCurrentState().getName());

        machine.sendEvent(OrderEvent.PAY);
        System.out.println("현재 상태: " + machine.getCurrentState().getName());

        machine.sendEvent(OrderEvent.SHIP);
        System.out.println("현재 상태: " + machine.getCurrentState().getName());

        machine.sendEvent(OrderEvent.DELIVER);
        System.out.println("현재 상태: " + machine.getCurrentState().getName());
    }
}