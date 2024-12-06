package state_machine.core;

/**
 * 상태 기계의 이벤트를 나타내는 인터페이스
 */
public interface Event {
    /**
     * 이벤트의 이름을 반환합니다.
     * 
     * @return 이벤트 이름
     */
    String getName();
}