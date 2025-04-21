package chapter0_introductions.basicconcurrency;

import java.awt.*;
import java.util.concurrent.*;


/**
 * We use Callable to define a task that returns a value.
 * We submit it to an ExecutorService, which returns a Future to get the result.
 * Callable -> submited to -> ExecutorService -> returns Future
 */


/**
 * Callable<V> is a functional interface like Runnable
 * Runnable - doesn't return a value / Callable does
 * Runnable - doesn't throw checked exception / Callable does
 * Runnable - used with Thread, ExecutorService / Callable only with ExecutorService
 */

/**
 * Future<V> represents the result of an asynchronous computation — you get it after submitting a Callable.
 * Key methods are:
 * 1) get() — blocks and returns result
 * 2) get(timeout) — wait with timeout]
 * 3) cancel() — tries to cancel the task
 * 4) isDone() — checks if task is complete
 * 5) isCancelled() — was it cancelled?
 */

/**
 * ExecutorService is the manager for threads — think of it as a thread pool or a task scheduler.
 * We submit Runnable or Callable tasks to it, and it runs them in background threads.
 */
public class D_ExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Hello from Callable";
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(task);
        String result = future.get();
        executor.shutdown();
        System.out.println(result);
    }
}


