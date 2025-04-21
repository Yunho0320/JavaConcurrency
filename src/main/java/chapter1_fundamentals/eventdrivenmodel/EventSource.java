package chapter1_fundamentals.eventdrivenmodel;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
    private final List<MyEventListener> listeners = new ArrayList<>();

    public void addListener(MyEventListener listener) {
        listeners.add(listener);
    }

    public void fireEvent(String message) {
        MyEvent event = new MyEvent(message);
        for (MyEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
