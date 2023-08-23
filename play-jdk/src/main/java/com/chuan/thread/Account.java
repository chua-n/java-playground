package com.chuan.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xucy-e
 */
@AllArgsConstructor
@Data
public class Account {
    /**
     * 账号
     */
    private Long accountId;
    /**
     * 余额
     */
    private int balance;
}
