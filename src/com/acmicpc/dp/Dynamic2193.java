package com.acmicpc.dp;

import java.util.Scanner;

public class Dynamic2193 {

    public static long[][] d;

    public static long getPinaryNumber(int n) {
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                d[i][1] = 1;
            }
            else {
                d[i][1] = d[i - 1][0];
//                System.out.println("d["+i+"][1]: " + d[i - 1][0]);
//                System.out.println("d["+i+"][0]: " + d[i - 1][0] + "+" + d[i - 1][1]);
                d[i][0] = d[i - 1][0] + d[i - 1][1];
            }
        }

        return d[n][0] + d[n][1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        d = new long[n + 1][2];

        System.out.println(getPinaryNumber(n));
    }
}
