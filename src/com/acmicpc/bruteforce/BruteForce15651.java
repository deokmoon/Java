package com.acmicpc.bruteforce;

import java.io.*;


public class BruteForce15651 {
    public static int[] sequenceArr = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void printSequece(int index, int n, int m) throws IOException {
        if (index > m) {
            for (int i = 1; i <= m; i++) {
                bw.write(sequenceArr[i] + " ");
            }
            bw.newLine();

            return;
        }

        for (int i = 1; i <= n; i++) {
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

        br.close();
        bw.flush();
        bw.close();
    }
}
