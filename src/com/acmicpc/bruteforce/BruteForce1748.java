package com.acmicpc.bruteforce;

import java.util.Scanner;

public class BruteForce1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int pos = 1;
        int sum = 0;
        int cnt = 1;

        while(true) {
            if (n > pos && n >= pos * 10) {
                sum += pos * 9 * cnt++;
                pos *= 10;
            } else if(n >= pos && n < pos * 10) {
                sum += (n - pos + 1) * cnt;
                break;
            }else {
                sum += (n - pos + 1) * cnt;
                break;
            }
        }
        System.out.println(sum);
    }
}
