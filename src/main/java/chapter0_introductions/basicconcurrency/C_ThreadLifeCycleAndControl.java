package chapter0_introductions.basicconcurrency;

/*
Thread lifecycle on a high level
State  - What it means
New	- Thread object created but start() not called yet
Runnable - Thread is ready to run, waiting for CPU
Running	- Thread is actively executing run()
Blocked	- Waiting to enter a synchronized block
Waiting	- Waiting indefinitely for another thread to notify it
Timed Waiting - Waiting for a specific time (e.g., sleep(), join(timeout))
Terminated - Finished execution or got killed
 */
public class C_ThreadLifeCycleAndControl {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 1. thread start()
         */
        Thread t = new Thread(() -> {
            System.out.println("Running: " + Thread.currentThread().getName());
        });
        t.start(); //Runs a new thread



        /**
         *  2. thread sleep(milliseconds)
         */
        Thread.sleep(1000); // Pauses current thread for 1 second



        /**
         * 3. thread join()
         */
        Thread t2 = new Thread(() -> {
            // some work
        });
        t2.start();
        t2.join(); // the current thread waits for thread t to finish



        /**
         * 4. thread interrupt()
         */
        Thread t3 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // keep working
            }
        });
        t3.start();
        t3.interrupt(); // Sending a signal for thread to stop



        /**
         * 5. Thread.yield()
         */
        Thread.yield(); // Pause thread
        // If in case there are no waiting threads or if all the waiting threads have low priority then the same thread will continue its execution.


        /**
         * 6. Thread.currentThread()
         */
        Thread t4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()); // Static method to get the current thread object
        });


        /**
         * 7. Daemon Thread
         */
        Thread t5 = new Thread(() -> {
            // background work
        });
        t5.setDaemon(true); // Makes a thread into a Daemon thread
        t5.start();
        // Daemon threads are background threads (e.g., garbage collection, loggers)
        //JVM will exit even if daemon threads are still running
        // if it's a normal thread, JVM will wait for it to finish before shutting down


    }
}
