package com.hackerRank;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n > 0) {
            int[] inputInteger = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(Integer.toString(inputInteger[0] + inputInteger[1]) + "\n");
            bw.flush();
            bw.close();

            n--;
        }
    }
}
