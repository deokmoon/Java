package com.leetcode.hashtable;

public class CountPrimes204 {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int[] arr = new int[n];
        int res = 0;

        // 에라토스테네스의 체
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) {
                for(int j = i + i; j < arr.length; j += i) {
                    arr[j] = 1;
                }
            } else {
                continue;
            }
        }

        for(int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) res++;
        }
        return res;
    }
}
