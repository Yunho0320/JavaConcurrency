package chapter0_introductions.basicconcurrency;

public class A_ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

/*
Extending a class to the Thread class is less preferred because this ties our task to the Thread object itself
 */