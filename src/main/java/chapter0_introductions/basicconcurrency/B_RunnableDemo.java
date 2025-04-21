package chapter0_introductions.basicconcurrency;

public class B_RunnableDemo {
    public static void main(String[] args) {
        Runnable task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
    }
}
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
    }
}


/*
This more preferred than A_ThreadDemo

1) Separation of concerns
Runnable task = new MyTask();       // describes *what* to do
Thread thread = new Thread(task);   // describes *how* to run it
So Runnable is the task logic, and Thread is the execution mechanism

2) Better object-oriented design
Java only supports one class to be extended.
If we extend Thread, we can't implement other classes.

3) Reusability
Runnable task = new MyTask();
new Thread(task).start();
new Thread(task).start();
We can pass the same task to different threads or executors

4) Integration with Executor Framework
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(new MyTask()); //MyTask which implements Runnable in the code above
We can’t submit a Thread object to an executor — only tasks.
 */