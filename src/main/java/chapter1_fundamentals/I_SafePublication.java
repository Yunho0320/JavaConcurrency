package chapter1_fundamentals;

/*
This code shows how to publish safely in 4 methods using the examples we used so far
 */

public class I_SafePublication {

    /*
    1. Static Initializer
    100% safe because the JVM ensures class initialization is thread-safe via internal synchronization (<clinit>).
    Any thread accessing holder will see a fully constructed object.
     */
    public static Holder holder = new Holder(42);

    /*
    2. Volatile fields or AtomicReference
    Writing to a volatile variable ensures that the reference is visible to all threads The object is fully constructed before it’s visible
    AtomicReference works the same because it uses volatile under the hood.
     */
    private volatile Holder holder2;

    /*
    3. Final fields of a properly constructed object
    If the SafeWrapper is fully constructed and no this escapes during construction,
    its final fields (like holder) are guaranteed to be seen correctly by other threads.
     */
    public final class SafeWrapper {
        private final Holder holder = new Holder(42);
    }

    /*
    4. Fields guarded by a lock
     */
    private Holder holder3;

    public synchronized void setHolder(Holder h) {
        holder = h;
    }

    public synchronized Holder getHolder() {
        return holder;
    }

}
class Holder{
    private int x;
    Holder(int x){
        this.x=x;
    };
}
