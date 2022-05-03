package com.acmicpc.bruteforce;

import java.io.*;

public class BruteForce18290Second {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, m, k, ans = -2147483647;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] map;
    public static int[][] arr;

    public static void calMaxSum(int cnt, int sum, int prev) throws IOException {
        if (cnt == k) {
            if (ans < sum) ans = sum;
            return;
        }
        for (int j = prev+1; j < n*m; j++) { // r,c -> r*M(열의개수)+c
            int x = j / m;
            int y = j % m;
            if (map[x][y]) continue;
            boolean isOk = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny]) isOk = false;
                }
            }
            if (isOk) {
                map[x][y] = true;
                calMaxSum(cnt + 1, sum+arr[x][y], x*m + y);
                map[x][y] = false;

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.valueOf(line[0]);
        m = Integer.valueOf(line[1]);
        k = Integer.valueOf(line[2]);
        arr = new int[n][m];
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.valueOf(line[j]);
            }
        }
        calMaxSum(0, 0, -1);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
