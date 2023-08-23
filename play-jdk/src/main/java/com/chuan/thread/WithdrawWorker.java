package com.chuan.thread;

import java.util.concurrent.Callable;

/**
 * @author xucy-e
 */
public class WithdrawWorker implements Callable<Integer> {
    private final Account account;

    private final int withdrawAmount;

    public WithdrawWorker(Account account, int withdrawAmount) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public Integer call() {
        Thread currentThread = Thread.currentThread();
        if (account.getBalance() >= withdrawAmount) {
            // 吐出钞票
            System.out.println(currentThread.getName() + "取钱成功！吐出钞票：" + this.withdrawAmount);
            // 修改余额
            account.setBalance(account.getBalance() - this.withdrawAmount);
            System.out.println(currentThread.getName() + "余额为：" + account.getBalance());
        } else {
            System.out.println(currentThread.getName() + "取钱失败！余额不足！");
            throw new RuntimeException(currentThread.getName());
        }
        return account.getBalance();
    }
}
