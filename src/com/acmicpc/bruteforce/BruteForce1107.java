package com.acmicpc.bruteforce;

import java.util.Scanner;

public class BruteForce1107 {
    public static boolean[] broken = new boolean[10];

    public static int checkMovePossible(int channel) {
        int cnt = 0; // 몇번의 버튼을 누르는지

        if (channel == 0) {
            if (broken[0]) return 0;
            else return 1;
        }
        // 각 자리수가 고장난 버튼이 있는지 체크
        while (channel > 0) {
            if(broken[channel % 10]) return 0;
            channel /= 10;
            cnt += 1;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            broken[a] = true;
        }

        int res = N - 100;
        if(res == 0) {
            System.out.println(res);
            System.exit(0);
        }
        if(res < 0) res = -res;

        // 채널 모두 다 검증(BruteForce) / 숫자버튼 우선 -> 가장적은 차이 계산
        for(int i = 0; i <= 1000000; i++) {
            int tempChannel = i;
            int cnt = checkMovePossible(tempChannel);
            if (cnt > 0) { // 숫자버튼 이동이 가능한 경우만 계산
                int temp = Math.abs(tempChannel - N) + cnt;
                if (temp < res) res = temp;
            }
        }
        System.out.println(res);
    }
}
