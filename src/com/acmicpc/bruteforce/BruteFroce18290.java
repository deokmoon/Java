package com.acmicpc.bruteforce;

import java.io.*;

public class BruteFroce18290 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n, m, ans = -2147483647;
    public static int[][] arr;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] map;

    public static void calMaxSum(int cnt, int sum, int prevX, int prevY) throws IOException {
        if (cnt == 0) {
            if (ans < sum) ans = sum;
            return;
        }
        for (int x = prevX; x < n; x++) {
            for (int y = (prevX == x? prevY: 0); y < m; y++) {
                if (map[x][y]) continue;
                boolean isOk = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny]) isOk = false;
                    }
                }
                if (isOk) {
                    map[x][y] = true;
                    calMaxSum(cnt - 1, sum + arr[x][y], x, y);
                    map[x][y] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.valueOf(line[0]);
        m = Integer.valueOf(line[1]);
        int k = Integer.valueOf(line[2]);
        arr = new int[n][m];
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.valueOf(line[j]);
            }
        }

        calMaxSum(k, 0, 0, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
