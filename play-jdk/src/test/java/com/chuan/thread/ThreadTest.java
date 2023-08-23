package com.chuan.thread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author xucy-e
 */
public class ThreadTest {
    private Account account;

    @Before
    public void setUp() {
        this.account = new Account(10086L, 1000);
    }

    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new WithdrawWorker(account, 1200));
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("This is main thread.");
        int balance = futureTask.get();
        System.out.println("Sub thread is down.");
        Assert.assertEquals(balance, account.getBalance());
    }

    @Test
    public void testThreadSafetyProblem() {
        FutureTask<Integer> futureTask1 = new FutureTask<>(new WithdrawWorker(account, 800));
        Thread thread1 = new Thread(futureTask1);

        FutureTask<Integer> futureTask2 = new FutureTask<>(new WithdrawWorker(account, 800));
        Thread thread2 = new Thread(futureTask2);

        thread1.start();
        thread2.start();

        System.out.println(Thread.currentThread().getName() + " thread runs over.");
    }

    @Test
    public void testThreadPool() throws InterruptedException {
        int numOfProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numOfProcessors);
        for (int i = 0; i < 17; i++) {
            executorService.submit(new WithdrawWorker(account, 800));
        }
        executorService.shutdown();
        System.out.println("isShutdown: " + executorService.isShutdown());
        System.out.println("isTerminated: " + executorService.isTerminated());
        boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("awaitTermination: " + awaitTermination);
        System.out.println("isTerminated: " + executorService.isTerminated());
    }
}
