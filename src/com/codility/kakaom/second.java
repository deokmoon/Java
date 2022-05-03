package com.codility.kakaom;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
class Solution {
    public int cnt = 0;
    boolean[] visited;

    public void calSkillCnt(int index, int[] T) {
        if(index == 0) {
            if(visited[0]) return;
            visited[0] = true;
            cnt++;
            return;
        }
        if(visited[index]) {
            index = T[index];
            calSkillCnt(index, T);
        } else {
            visited[index] = true;
            cnt++;
            index = T[index];
            calSkillCnt(index, T);
        }

    }
    public int solution(int[] T, int[] A) {
        int tLength = T.length;
        int aLength = A.length;
        visited = new boolean[tLength];

        for(int i = 0; i < aLength; i++) {
            calSkillCnt(A[i], T);
        }
        return cnt;
    }
}

 */
