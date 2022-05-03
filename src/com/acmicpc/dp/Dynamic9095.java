package com.acmicpc.dp;

import java.util.Scanner;

public class Dynamic9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[12];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        while(n-- > 0) {
            int num = sc.nextInt();

            for(int i = 4; i <= num; i++) {
                d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            }
            System.out.println(d[num]);
        }

    }
}
