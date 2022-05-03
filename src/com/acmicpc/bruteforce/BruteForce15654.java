package com.acmicpc.bruteforce;

import java.io.*;
import java.util.Arrays;

public class BruteForce15654 {
    public static int inputArr[];
    public static int sequence[] = new int[10];
    public static boolean isUsed[] = new boolean[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printSequence(int index, int n, int m) throws IOException{
        if (index == m) {
            for (int i = 0; i < m; i++) {
                bw.write(sequence[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed[i]) continue;;
            sequence[index] = inputArr[i];
            isUsed[i] = true;
            printSequence(index + 1, n, m);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);

        inputArr = new int[n];
        line = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.valueOf(line[i]);
        }

        Arrays.sort(inputArr);
        printSequence(0, n, m);

        br.close();
        bw.flush();
        bw.close();
    }
}
