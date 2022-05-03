package com.acmicpc.bruteforce.recursive.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2529
 * 부등호 문제(Backtracking BruteForce 가능)
 * Backtracking으로 처리
 * @since 2021.12
 */
public class BackTracking2529 {
    public static int n;
    public static char[] sign = new char[10];
    public static boolean[] isVisited = new boolean[10];
    public static List<String> ans = new ArrayList<>();

    public static void calcValue(int index, String strVal) {
        if (index == n+1) {
            ans.add(strVal);
        }
        for (int i = 0; i < 10; i++) {
           if (isVisited[i]) continue;
           if (index == 0 || isOk(strVal.charAt(index-1), (char)(i+'0'), sign[index-1])) {
               isVisited[i] = true;
               calcValue(index + 1, strVal + String.valueOf(i));
               isVisited[i] = false;
            }
        }
    }
    public static boolean isOk(char pre, char post,  char op) {
        if (op == '<' && pre < post) {
            return true;
        }
        if (op == '>' && pre > post) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++) {
            sign[i] = sc.next().toCharArray()[0];
        }

        calcValue(0, "");
        Collections.sort(ans);

        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));
    }
}
