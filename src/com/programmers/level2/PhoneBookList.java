package com.programmers.level2;

import java.util.Arrays;

public class PhoneBookList {
    public static void main(String[] args) {
        Solutuin sol = new Solutuin();
        String[] input = {"123","456","789"};
        System.out.println(sol.solution(input));
    }
    private static class Solutuin{
        public boolean solution(String[] phoneBook) {

            Arrays.sort(phoneBook);
            for (int i = 0; i < phoneBook.length - 1; i++) {
                if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                    return false;
                }
            }

            return true;
        }
    }
}
