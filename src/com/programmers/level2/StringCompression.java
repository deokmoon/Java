package com.programmers.level2;

/**
 * 문자열 압축문제(level 2)
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 *
 * 접근방식:
 *  - 문제의 출제는 압축된 문자열 출력이 아닌, "최소 길이"
 *      => 2ab2cd2ab2cd == 2222abcdabcd
 */
public class StringCompression {
    private static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String prev = s.substring(0, i);
            String tempStr = "";
            String last = "";
            int cnt = 1;
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if (prev.equals(s.substring(j, j + i))) {
                    cnt += 1;
                } else {
                    tempStr += prev;
                    if (cnt > 1) {
                        tempStr = cnt + tempStr;
                        cnt = 1;
                    }
                    prev = s.substring(j, j + i);
                }
            }
            tempStr += prev + last;
            if (cnt > 1) {
                tempStr = cnt + tempStr;
            }
            answer = Math.min(tempStr.length(), answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}
