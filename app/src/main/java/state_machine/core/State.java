package state_machine.core;

/**
 * 상태 기계의 상태를 나타내는 인터페이스
 */
public interface State {
    /**
     * 상태의 이름을 반환합니다.
     * 
     * @return 상태 이름
     */
    String getName();
}