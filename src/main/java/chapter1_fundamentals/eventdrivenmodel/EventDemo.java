package chapter1_fundamentals.eventdrivenmodel;

/*
This module 'eventdrivenmodel' demonstrates a very simple Java Event Listener Model
The diagram 'event-model-architecture' can be referred.
Common definitions:
- Event : a class to carry event data
- Listener Interface : declares what should happen when an event occurs
- Source (Publisher) : the object that fires the event
- Handler (Subscriber) : the class that listens to the event and reacts
.
 */
public class EventDemo {
    public static void main(String[] args) {
        EventSource source = new EventSource();

        // Register two handlers/subscribers
        source.addListener(new MyHandler("Handler1"));
        source.addListener(new MyHandler("Handler2"));

        // Fire event
        source.fireEvent("Hello, world!");
    }
}
