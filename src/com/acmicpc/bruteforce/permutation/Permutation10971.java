package com.acmicpc.bruteforce.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10971
 * TPS 외판원순회 문제
 * Permutation(순열)로 처리
 *
 * @since 2021.12
 */
public class Permutation10971 {
    public static int n;
    public static int[][] d;
//          public static boolean[] isVisited;
    public static List<Integer> costList = new ArrayList<Integer>();

    public static boolean hasNextPermutation(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while(i > 0 && arr[i - 1] > arr[i]) {
            i--;
        }

        if( i <= 0) {
            return false;
        }

        while(arr[i - 1] > arr[j]) {
            j--;
        }

        // switch
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        // aesc
        j = arr.length - 1;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        if(arr[0] > 0 ) {
            return false;
        }

        return true;
    }

    public static  void calcCost(int[][] permutation, int idx) {
        for(int i = 0; i < idx; i++) {
            boolean hasZero = false;
            int sum = 0;

            for(int j = 0; j < n ; j++) {
                if(j + 1 < n) {
                    if(d[permutation[i][j]][permutation[i][j + 1]] == 0 ) {
                        hasZero = true;
                    }
                    sum += d[permutation[i][j]][permutation[i][j + 1]];
                } else { // last -> comeback
                    if(d[permutation[i][j]][permutation[i][0]] == 0 ) {
                        hasZero = true;
                    }
                    sum += d[permutation[i][j]][permutation[i][0]];
                }
            }
            if(!hasZero) {
                costList.add(sum);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        int[][] permutation = new int[362880][n];

        d = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }

        // first permutation
        for(int i = 0; i < n; i++) {
            arr[i] = i;
            permutation[0][i] = arr[i];
        }
        // full permutation
        int idx = 1;
        while(hasNextPermutation(arr)) {
            System.out.println("idx: " + idx + " " + arr[0] +  arr[1] + arr[2] + arr[3]);
            for(int i = 0; i < n; i++) {
                permutation[idx][i] = arr[i];
            }
            idx++;
        }
        System.out.println("=======");
        for(int i = 0; i < idx; i++) {
            System.out.print("idx: " + i + " ");
            for(int j = 0; j < n ; j++) {
                System.out.print(permutation[i][j] );
            }
            System.out.println();
        }

        calcCost(permutation, idx);

        Arrays.sort(costList.toArray());
        System.out.println(costList.get(0));
        System.out.println(costList.get(costList.size() - 1));

    }

}