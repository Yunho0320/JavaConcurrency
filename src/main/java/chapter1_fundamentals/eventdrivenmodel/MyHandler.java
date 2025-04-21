package chapter1_fundamentals.eventdrivenmodel;

//Handler/subscriber/listener that listens to events
public class MyHandler implements MyEventListener {
    private final String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(MyEvent event) {
        System.out.println(name + " received event: " + event.getMessage());
    }
}
