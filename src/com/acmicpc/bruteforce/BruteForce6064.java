package com.acmicpc.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int M = Integer.valueOf(line[0]);
            int N = Integer.valueOf(line[1]);
            int x = Integer.valueOf(line[2]) - 1;
            int y = Integer.valueOf(line[3]) - 1;
            boolean isNotOk = true;
            for (int i = x; i < N*M; i += M) {
                if (i % N == y) {
                    System.out.println(i + 1);
                    isNotOk = false;
                    break;
                }
            }
            if (isNotOk) System.out.println(-1);
        }
    }
}
