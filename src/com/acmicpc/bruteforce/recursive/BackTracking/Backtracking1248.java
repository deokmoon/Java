package com.acmicpc.bruteforce.recursive.BackTracking;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2529
 * 부등호 문제(BruteForce 불가능)
 * Backtracking으로 처리
 *
 * @since 2021.12
 */
public class Backtracking1248 {
    public static int n;
    public static int[][] sign;
    public static int[] ans;

    public static boolean check(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += ans[i];
            if (sign[i][index] > 0 && sum <= 0) return false;
            if (sign[i][index] == 0 && sum != 0) return false;
            if (sign[i][index] < 0 && sum >= 0) return false;

        }
        return true;
    }

    public static boolean calcValue(int index) {
        if (index == n) {
            return true;
        }
        if (sign[index][index] == 0 ) {
            ans[index] = 0;
            return check(index) && calcValue(index + 1);
        }
        for (int i = 1; i <= 10; i++) {
            ans[index] = sign[index][index] * i;
            if (check(index) && calcValue(index + 1)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sign = new int[n][n];
        ans = new int[n];
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s.charAt(cnt) == '0') {
                    sign[i][j] = 0;
                }
                else if (s.charAt(cnt) == '-') {
                    sign[i][j] = -1;
                }
                else {
                    sign[i][j] = 1;
                }
                cnt++;
            }
        }
        calcValue(0);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
