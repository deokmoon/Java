package com.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 2021.03.17
 * Stack 기초
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        ArrayList<String> arr = new ArrayList<>();
        arr.add(s.substring(0, 1));
        for(int i = 1; i < s.length(); i++) {
            if(map.get(s.substring(i, i + 1)) != null) {
                if(arr.size() == 0) return false;
                if(arr.get(arr.size() - 1) != null &&
                        arr.get(arr.size() - 1).equals(map.get(s.substring(i, i + 1)))) {
                    arr.remove(arr.size() - 1);
                } else {
                    return false;
                }
            } else {
                arr.add(s.substring(i, i + 1));
            }
        }
        if(arr.size() != 0) return false;

        return true;
    }

    /**
     *  LeetCode 내 Java 풀이 중 가장 심플한 케이스
     *  Stack의 원리 및 문제 출제 원리를 잘 이용함
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
