package chapter1_fundamentals.eventdrivenmodel;

//This class represents an event - carries data (messsage) from the source to the listener
public class MyEvent {
    private final String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
