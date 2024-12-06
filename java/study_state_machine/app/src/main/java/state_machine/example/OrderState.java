package state_machine.example;

import state_machine.core.State;

public enum OrderState implements State {
    CREATED("생성됨"),
    PAID("결제됨"),
    SHIPPED("배송중"),
    DELIVERED("배송완료"),
    CANCELLED("취소됨");

    private final String name;

    OrderState(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}