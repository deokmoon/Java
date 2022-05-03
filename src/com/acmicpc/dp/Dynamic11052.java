package com.acmicpc.dp;

import java.util.Scanner;

public class Dynamic11052 {

    public static void calcCost(int n, int[] m, int[] p) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (m[i] < m[i - j] + p[j]) {
                    m[i] = m[i - j] + p[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        calcCost(n, m, p);

        System.out.println(m[n]);
    }
}
