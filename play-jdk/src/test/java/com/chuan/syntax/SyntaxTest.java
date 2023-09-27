package com.chuan.syntax;

import org.junit.Test;

/**
 * 玩一下各种java语法
 */
public class SyntaxTest {
    @Test
    public void testSwitch() {
        int x = 1;
        switch (x) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
            default:
                System.out.println("default");
        }
    }
}
