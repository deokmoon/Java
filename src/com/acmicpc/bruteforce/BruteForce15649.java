package com.acmicpc.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce15649 {
    public static boolean[] isNumberUsed = new boolean[10]; // 사용된 숫자인지
    public static int[] sequence = new int[10]; // 수열의 인덱스 확인용

    public static void printSequece(int index, int n, int m) {
        if (index > m) {
            for (int i = 1; i <= m; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = 1; i <= n; i++) {
            if (isNumberUsed[i]) continue; // 숫자 사용여부 확인
            isNumberUsed[i] = true;
            sequence[index] = i;
            printSequece(index + 1, n, m);
            isNumberUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.valueOf(line[0]);
        int M = Integer.valueOf(line[1]);

        printSequece(1, N, M);
    }
}
