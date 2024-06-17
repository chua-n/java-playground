package com.chuan.coding;

import org.junit.Test;

import java.util.*;

/**
 * @author xucy-e
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = in.nextInt();
            }
            int k = in.nextInt();
            System.out.println(values[n - k]);
        }
    }

    private static int solve(String string) {
        return 0;
    }

    @Test
    public void testSolve() {
    }
}
