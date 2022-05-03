package com.codility.kakaom;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
class Solution {
    public int solution(int[] A) {
        int length = A.length;
        int max = 0;

        int postIndex = length - 1;
        int cnt = 0;
        for(int i = 0; i < length; i++) { // odd
            if(i < postIndex && A[i] == A[postIndex]) {
                cnt += 2;
                postIndex--;
                if(max < cnt) max = cnt;
            } else if(i == postIndex && A[i] == A[postIndex]) {
                cnt ++;
                postIndex--;
                if(max < cnt) max = cnt;
            } else {
                cnt = 0;
                postIndex = length - 1;
            }
        }

        cnt = 0;
        int chk = 0;
        for(int i = 0; i < length; i++) { // even
            if(i + 2 < length && A[i] == A[i + 2]) {
                chk++;
                if(chk % 2 == 0) cnt += 4;
                if(max < cnt) max = cnt;
            } else {
                cnt = 0;
                chk = 0;
            }
        }
        return max;
    }
}
*/
