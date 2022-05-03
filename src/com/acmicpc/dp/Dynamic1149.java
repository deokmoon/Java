package com.acmicpc.dp;

import java.util.Scanner;

/**
 * RGB거리 문제
 * https://www.acmicpc.net/problem/1149
 *
 * 인접한 집의 각 색깔은 다름
 *  - arr[i][j] -> i번째 집을 j(색깔)을 칠할 떄의 각 비용
 *  - cost[i][j]  -> i번째 집을 j(색깔)을 칠했을 떄의 총 비용(누적분)
 */
public class Dynamic1149 {
    public static int[][] cost;

    public static int getMinCost(int n, int[][] arr) {
        for (int i = 0; i < 3; i++) {
            cost[0][i] = arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            cost[i][0] = arr[i][0] + Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] = arr[i][1] + Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] = arr[i][2] + Math.min(cost[i - 1][0], cost[i - 1][1]);
        }

        return Math.min(Math.min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // check input
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(getMinCost(n, arr));
    }
}
