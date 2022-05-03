package com.acmicpc.simulation;

import java.util.Scanner;

public class Simulation16935 {
    public static int arr[][];
    public static int opArr[];

    // 상하반전
    public static void operation1(int n, int m) {
        int idx = n - 1;
        for (int i=0; i<n/2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[j][idx];
                arr[j][idx] = temp;
            }
            idx--;
        }
    }
    // 좌우반전
    public static void operation2(int n, int m) {
        int idx = m - 1;
        for (int i=0; i<m/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[idx][j];
                arr[idx][j] = temp;
            }
            idx--;
        }
    }
    // 오른쪽 90도
    public static void operation3(int n, int m) {
        int temp[][] = new int[n][m];
        int idx = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[idx][j] = arr[j][i];
            }
            idx--;
        }
        arr = temp.clone();
    }
    // 왼쪽 90도
    public static void operation4(int n, int m) {
        int temp[][] = new int[n][m];
        int idx = m - 1;
        for (int i = 0; i < n; i++) {
            idx = m - 1;
            for (int j = 0; j < m; j++) {
                temp[i][idx] = arr[j][i];
                idx--;
            }
        }
        arr = temp.clone();
    }
    // 시계방향
    public static void operation5(int n, int m) {
        int temp[][] = new int[m][n];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[j + (m/2)][i] = arr[j][i];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = (m/2); j < m; j++) {
                temp[j][i + (n/2)] = arr[j][i];
            }
        }
        for (int i = (n/2); i < n; i++) {
            for (int j = (m/2); j < m; j++) {
                temp[j - (m/2)][i] = arr[j][i];
            }
        }
        for (int i = (n/2); i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[j][i - (n/2)] = arr[j][i];
            }
        }
        arr = temp.clone();
    }
    // 반시계방향
    public static void operation6(int n, int m) {
        int temp[][] = new int[m][n];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[j][i+ (n/2)] = arr[j][i];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = (m/2); j < m; j++) {
                temp[j - (m/2)][i] = arr[j][i];
            }
        }
        for (int i = (n/2); i < n; i++) {
            for (int j = (m/2); j < m; j++) {
                temp[j][i-(n/2)] = arr[j][i];
            }
        }
        for (int i = (n/2); i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[j+(m/2)][i] = arr[j][i];
            }
        }
        arr = temp.clone();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        arr = new int[m][n];
        opArr = new int[r];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j][i] = sc.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            opArr[i] = sc.nextInt();
        }
        for (int i = 0; i < opArr.length; i++) {
            switch (opArr[i]) {
                case 1:
                    operation1(n, m);
                    break;
                case 2:
                    operation2(n, m);
                    break;
                case 3:
                    operation3(n, m);
                    int temp = n;
                    n = m;
                    m = temp;
                    break;
                case 4:
                    operation4(n, m);
                    temp = n;
                    n = m;
                    m = temp;
                    break;
                case 5:
                    operation5(n, m);
                    break;
                case 6:
                    operation6(n, m);
                    break;
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}
