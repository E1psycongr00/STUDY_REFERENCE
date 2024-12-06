package state_machine.core;

import java.util.List;

/**
 * 상태 기계의 핵심 인터페이스
 */
public interface StateMachine {
    /**
     * 현재 상태를 반환합니다.
     * 
     * @return 현재 상태
     */
    State getCurrentState();

    /**
     * 이벤트를 처리합니다.
     * 
     * @param event 처리할 이벤트
     * @return 상태 전이 성공 여부
     */
    boolean sendEvent(Event event);

    /**
     * 상태 변경 리스너를 추가합니다.
     * 
     * @param listener 상태 변경 리스너
     */
    void addStateChangeListener(StateChangeListener listener);

    /**
     * 상태 변경 리스너를 제거합니다.
     * 
     * @param listener 제거할 리스너
     */
    void removeStateChangeListener(StateChangeListener listener);

    /**
     * 상태 기계를 시작합니다.
     */
    void start();

    /**
     * 상태 기계를 중지합니다.
     */
    void stop();

    /**
     * 모든 상태 목록을 반환합니다.
     * 
     * @return 상태 목록
     */
    List<State> getStates();

    /**
     * 상태 변경을 감지하는 리스너 인터페이스
     */
    @FunctionalInterface
    interface StateChangeListener {
        void onStateChanged(State from, State to, Event event);
    }
}