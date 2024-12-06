package state_machine.core;

/**
 * 상태 전이를 나타내는 클래스
 */
public class Transition {
    private final State sourceState;
    private final State targetState;
    private final Event event;
    private TransitionAction action;

    public Transition(State sourceState, State targetState, Event event) {
        this.sourceState = sourceState;
        this.targetState = targetState;
        this.event = event;
    }

    public State getSourceState() {
        return sourceState;
    }

    public State getTargetState() {
        return targetState;
    }

    public Event getEvent() {
        return event;
    }

    public void setAction(TransitionAction action) {
        this.action = action;
    }

    public void executeAction() {
        if (action != null) {
            action.execute(sourceState, targetState, event);
        }
    }

    @FunctionalInterface
    public interface TransitionAction {
        void execute(State source, State target, Event event);
    }
}