package chapter1_fundamentals.eventdrivenmodel;

// IT declares a contract. Any class that wants to listen to events must implement this and define onEvent
public interface MyEventListener {
    void onEvent(MyEvent event);
}
