package com.acmicpc.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BruteForce15652 {
    public static int[] sequenceArr = new int[10];
    public static void printSequece(int index, int n, int m) {
        if (index > m) {
            for (int i = 1; i <= m; i++) {
                System.out.print(sequenceArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (sequenceArr[index - 1] > i) continue;
            sequenceArr[index] = i;
            printSequece(index + 1, n, m);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);

        printSequece(1, n, m);
    }
}
