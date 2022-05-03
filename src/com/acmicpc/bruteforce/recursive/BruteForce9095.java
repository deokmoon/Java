package com.acmicpc.bruteforce.recursive;

import java.util.Scanner;

public class BruteForce9095 {
    public static int getCount(int n, int sum) {
        if (n == sum) return 1;
        if (n < sum) return 0;

        int now = 0;
        for (int i = 1; i <= 3;i ++) {
            now += getCount(n, sum + i);
        }
        return now;
    }
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 0;

        while (t-- > 0) {
            int n = sc.nextInt();
            cnt = getCount(n, 0);
            System.out.println(cnt);
        }
    }
}
