package com.hackerRank;

public class Result {
    public static long repeatedString(String s, long n) {
        // Write your code here
        long result = 0, count = 0, remain = 0;
        int length = s.length();

        for(int i = 0; i < length; i++) {
            if('a' == s.charAt(i)) count++;
        }
        result = (n / length) * count;
        remain = n % length;

        for(int i = 0; i < remain; i++) {
            if('a' == s.charAt(i)) result++;
        }

        return result;
    }
}
