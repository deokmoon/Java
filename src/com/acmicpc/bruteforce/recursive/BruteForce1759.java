package com.acmicpc.bruteforce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteForce1759 {
    public static boolean[] isUsed;
    public static char[] charArr;
    public static void printPw(int l, String pw, String alphabet, int idx) {
        if (pw.length() == l) {
            if (isValidated(pw)) System.out.println(pw);
            return;
        }
        if (pw.length() > l || idx >= alphabet.length()) return;

        for (int i = idx; i < alphabet.length(); i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            printPw(l, pw + charArr[i], alphabet, i + 1);
            isUsed[i] = false;
        }
    }
    public static boolean isValidated(String pw) {
        char[] moArr = {'a', 'e', 'i', 'o', 'u'};
        int moCnt = 0;
        int jaCnt = 0;
        for (char c: pw.toCharArray()) {
            for (int i = 0; i < moArr.length; i++) {
                if (moArr[i] == c) moCnt++;
                else jaCnt++;
            }
        }
        return moCnt >= 1 && jaCnt >= 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int l = Integer.valueOf(line[0]);
        int c = Integer.valueOf(line[1]);

        isUsed = new boolean[c];
        String alphabet = br.readLine().replace(" ", "");
        charArr = alphabet.toCharArray();

        Arrays.sort(charArr);
        printPw(l, "", alphabet, 0);

    }
}
