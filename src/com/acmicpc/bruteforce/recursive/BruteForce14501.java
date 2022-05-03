package com.acmicpc.bruteforce.recursive;

import java.util.Scanner;

public class BruteForce14501 {
    public static int[] timeArr;
    public static int[] priceArr;
    public static int ans = 0;
    public static void getMaxPrice(int n, int day, int sum) {
        if (day == n) {
            if (sum > ans) ans = sum;
            return;
        }
        if (day > n) {
            return;
        }
        getMaxPrice(n, day + 1, sum);
        getMaxPrice(n, day + timeArr[day], sum + priceArr[day]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        timeArr = new int[n];
        priceArr = new int[n];

        for(int i = 0; i < n; i++) {
            timeArr[i] = sc.nextInt();
            priceArr[i] = sc.nextInt();
        }

        getMaxPrice(n, 0, 0);

        System.out.println(ans);
    }
}
