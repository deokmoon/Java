package com.acmicpc.dp;

import java.util.Scanner;

public class Dynamic11726 {

    public static void handleTileCnt(int n, int[] m) {
        m[1] = 1;
        if(n < 2) {
            return;
        }
        m[2] = m[1] + 1;
        for (int i = 3; i <= n; i++) {
            m[i] = (m[i - 1] + m[i - 2]) % 10007;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n + 1];

        handleTileCnt(n, m);

        System.out.println(m[n]);
    }
}
