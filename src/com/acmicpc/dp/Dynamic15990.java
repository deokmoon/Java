package com.acmicpc.dp;

import java.util.Scanner;

public class Dynamic15990 {

    public static long d[][] = new long[100001][4];
    public static long mod = 1000000009L;

    public static void calcCnt() {
        d[0][0] = 1;
        d[1][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
            d[i][1] = (d[i - 1][2] + d[i - 1][3]) % mod;
            d[i][2] = (d[i - 2][1] + d[i - 2][3]) % mod;
            d[i][3] = (d[i - 3][1] + d[i - 3][2]) % mod;
        }
    }
    public static void main(String[] args) {
        calcCnt();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int num = sc.nextInt();
            System.out.println((d[num][1] + d[num][2] + d[num][3]) % mod);
        }
    }
}
    