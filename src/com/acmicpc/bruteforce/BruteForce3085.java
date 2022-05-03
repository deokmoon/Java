package com.acmicpc.bruteforce;

import java.util.Scanner;

public class BruteForce3085 {
    public static int check(char[][] map, int n) {
        int ans = 1;

        // 연속성 확인(행/열)
        for (int i=0; i<n; i++) {
            int cnt = 1;
            for(int j=1; j<n; j++) {
                if (map[i][j] == map[i][j-1])
                    cnt++;
                else
                    cnt=1;
                if(ans<cnt) ans=cnt;
            }
            cnt=1;
            for(int j=1; j<n; j++) {
                if (map[j][i] == map[j-1][i])
                    cnt++;
                else
                    cnt=1;
                if(ans<cnt) ans=cnt;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];

        for(int i=0; i<n; i++) {
            map[i] = sc.next().toCharArray();
        }
        int ans = 0;
        // 하나씩(우/하) 수행, 인접한 2칸(다른색)
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // 우
                if(j+1 <n) {
                    // 교환
                    char t = map[i][j]; map[i][j] = map[i][j+1]; map[i][j+1] = t;
                    int cnt = check(map, n);
                    if (ans < cnt) ans = cnt;
                    // 원복
                    t = map[i][j]; map[i][j] = map[i][j+1]; map[i][j+1] = t;
                }

                // 하
                if(i+1 < n) {
                    char t = map[i][j]; map[i][j] = map[i+1][j]; map[i+1][j] = t;
                    int cnt = check(map, n);
                    if (ans < cnt) ans = cnt;
                    // 원복
                    t = map[i][j]; map[i][j] = map[i+1][j]; map[i+1][j] = t;
                }

            }
        }
        System.out.println(ans);
    }
}
