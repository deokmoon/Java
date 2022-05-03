//package com.codility.yanolja;
//
//public class MainClass4 {
//    public static void main(String[] args) {
//
//    }
//
//    static class Solution {
//        public int solution(String L1, String L2) {
//            char[][] road = new char[2][L1.length()];
//            road[0] = L1.toCharArray();
//            road[1] = L2.toCharArray();
//
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    // 우
//                    if(j+1 <n) {
//                        // 교환
//                        char t = map[i][j]; map[i][j] = map[i][j+1]; map[i][j+1] = t;
//                        int cnt = check(map, n);
//                        if (ans < cnt) ans = cnt;
//                        // 원복
//                        t = map[i][j]; map[i][j] = map[i][j+1]; map[i][j+1] = t;
//                    }
//
//                    // 하
//                    if(i+1 < n) {
//                        char t = map[i][j]; map[i][j] = map[i+1][j]; map[i+1][j] = t;
//                        int cnt = check(map, n);
//                        if (ans < cnt) ans = cnt;
//                        // 원복
//                        t = map[i][j]; map[i][j] = map[i+1][j]; map[i+1][j] = t;
//                    }
//
//                }
//            }
//
//            return 0;
//        }
//    }
//
//}
