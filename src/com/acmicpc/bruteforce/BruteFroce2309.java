package com.acmicpc.bruteforce;

import java.io.*;
import java.util.Arrays;

public class BruteFroce2309 {
    public static void main(String[] args) throws IOException {
        int[] h = new int[9];
        int[] idx = new int[2];
        int sum = 0;
        int dif = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            h[i] = Integer.parseInt(br.readLine());
            sum += h[i];
        }

        dif = sum - 100;
        for(int i = 0; i < 9; i++) {
            for(int j = i +1; j < 9; j++) {
                if(h[i] + h[j] == dif) {
                    idx[0] = h[i];
                    idx[1] = h[j];
                    break;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.sort(h);
        for(int i = 0; i < 9; i++) {
            if(h[i] == idx[0] || h[i] == idx[1]) continue;
            bw.write(h[i] + "\n");
            bw.flush();
        }

    }
}
