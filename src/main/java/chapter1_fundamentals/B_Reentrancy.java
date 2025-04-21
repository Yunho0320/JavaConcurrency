package chapter1_fundamentals;

// This demonstrates reentrancy property of synchronized
public class B_Reentrancy {
    public synchronized void outer() {
        System.out.println(Thread.currentThread().getName() + " entered outer()");
        inner();
        System.out.println(Thread.currentThread().getName() + " exiting outer()");
    }

    public synchronized void inner() {
        System.out.println(Thread.currentThread().getName() + " entered inner()");
        System.out.println(Thread.currentThread().getName() + " exiting inner()");
    }

    public static void main(String[] args) {
        B_Reentrancy demo = new B_Reentrancy();

        Thread threadA = new Thread(() -> {
            demo.outer();
        }, "Thread-A");

        threadA.start();
    }
}

/*
Output:
Thread-A entered outer()
Thread-A entered inner()
Thread-A exiting inner()
Thread-A exiting outer()
 */

