package com.programmers.level2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
//        int[] input = {0, 2, 3, 4, 5, 28, 58, 67, 91};
        int[] input = {0, 1, 3, 5, 6};
        System.out.println(new Solution().solution(input));
    }

    private static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int length = citations.length;

            Arrays.sort(citations);


            for (int i = 0; i < length; i++) {
                if ((length - i) <= (citations[i])) {
                    answer = length - i;
                    break;
                }
            }
            return answer;
        }
    }
}
