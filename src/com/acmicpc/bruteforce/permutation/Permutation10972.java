package com.acmicpc.bruteforce.permutation;

import java.util.Scanner;

public class Permutation10972 {
    public static int n;

    public static void calcNextPermutation(int[] curNum) {
        int i = curNum.length - 1;

        while (i > 0 && curNum[i - 1] >= curNum[i]) {
            i--;
        }
        if (i <= 0) {
            System.out.println(-1);
            System.exit(0);
        }

        int j = curNum.length - 1;

        while (curNum[i - 1] >= curNum[j]) {
            j--;
        }

        swap(curNum, i -1, j);

        j = curNum.length - 1;
        while (i < j) {
            int temp;
            temp = curNum[i];
            curNum[i] = curNum[j];
            curNum[j] = temp;
            i += 1;
        j -= 1;
    }

}

    public static void swap(int[] curNum, int i, int j) {
        int temp = curNum[i];
        curNum[i] = curNum[j];
        curNum[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] permutaiton = new int[n];

        for (int i = 0; i < n; i++) {
            permutaiton[i] = sc.nextInt();
        }

        calcNextPermutation(permutaiton);

        for (int i = 0; i < n; i++) {
            System.out.print(permutaiton[i] + " ");
        }
    }
}
