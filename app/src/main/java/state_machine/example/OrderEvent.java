package state_machine.example;

import state_machine.core.Event;

public enum OrderEvent implements Event {
    PAY("결제"),
    SHIP("배송시작"),
    DELIVER("배송완료"),
    CANCEL("취소");

    private final String name;

    OrderEvent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}