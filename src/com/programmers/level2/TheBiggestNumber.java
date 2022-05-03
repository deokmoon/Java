package com.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] input = {"3", "30", "34", "5", "9"};

        System.out.println(sol.solution(input));
    }

    private static class Solution {
        public String solution(String[] numbers) {
            String answer = "";

            Arrays.sort(numbers, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });
            for (String str : numbers) {
                answer += str;
            }
//            answer = Stream.of(numbers).sorted(
//                    (o1, o2) -> (o2+o1).compareTo(o1+o2)).collect(Collectors.joining());

            if ("0".equals(answer.substring(0, 1))) {
                return "0";
            }

            return answer;
        }
    }
}
