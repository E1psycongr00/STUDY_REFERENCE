package state_machine.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상태 기계의 기본 구현체
 */
public class DefaultStateMachine implements StateMachine {
    private State currentState;
    private final State initialState;
    private final Map<State, Map<Event, Transition>> transitions;
    private final List<StateChangeListener> listeners;
    private boolean started;

    public DefaultStateMachine(State initialState) {
        this.initialState = initialState;
        this.currentState = initialState;
        this.transitions = new HashMap<>();
        this.listeners = new ArrayList<>();
        this.started = false;
    }

    public void addTransition(State sourceState, State targetState, Event event) {
        transitions.computeIfAbsent(sourceState, k -> new HashMap<>())
                .put(event, new Transition(sourceState, targetState, event));
    }

    public void addTransition(State sourceState, State targetState, Event event, Transition.TransitionAction action) {
        Transition transition = new Transition(sourceState, targetState, event);
        transition.setAction(action);
        transitions.computeIfAbsent(sourceState, k -> new HashMap<>())
                .put(event, transition);
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }

    @Override
    public boolean sendEvent(Event event) {
        if (!started) {
            throw new IllegalStateException("상태 기계가 시작되지 않았습니다.");
        }

        Map<Event, Transition> stateTransitions = transitions.get(currentState);
        if (stateTransitions == null) {
            return false;
        }

        Transition transition = stateTransitions.get(event);
        if (transition == null) {
            return false;
        }

        State oldState = currentState;
        currentState = transition.getTargetState();
        transition.executeAction();
        notifyListeners(oldState, currentState, event);
        return true;
    }

    @Override
    public void addStateChangeListener(StateChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeStateChangeListener(StateChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(State from, State to, Event event) {
        listeners.forEach(listener -> listener.onStateChanged(from, to, event));
    }

    @Override
    public void start() {
        if (!started) {
            currentState = initialState;
            started = true;
        }
    }

    @Override
    public void stop() {
        started = false;
    }

    @Override
    public List<State> getStates() {
        return new ArrayList<>(transitions.keySet());
    }
}