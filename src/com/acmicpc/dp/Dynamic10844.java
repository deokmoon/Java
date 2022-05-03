package com.acmicpc.dp;

import java.util.Scanner;

public class Dynamic10844 {
    public static long[][] d;
    public static long mod = 1000000000L;

    public static long getStairsCount(int num) {
        long cnt = 0;

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < 10; j++) {
                if (i > 1) {
                    if (j - 1 >= 0 && j + 1 < 10) {
                        d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod;
                    }
                    if(j - 1 >= 0 && j + 1 > 9) {
                        d[i][j] = (d[i - 1][j - 1]) % mod;
                    }
                    if(j - 1 < 0 && j + 1 < 10) {
                        d[i][j] = (d[i - 1][j + 1]) % mod;
                    }
                } else {
                    if (j != 0) {
                        d[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < 10; i++ ){
            cnt += d[num][i];
        }

        return cnt % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n + 1][10];

        d[1][0] = 0;
        for (int i = 1; i < 10; i++) {
            d[1][i] = 1;
        }

        System.out.println(getStairsCount(n));
    }
}
