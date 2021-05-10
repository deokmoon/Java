package com.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
		boolean res = true;
		s = s.toLowerCase();
		t = t.toLowerCase();
		HashMap<Character, Integer> strData = new HashMap<>();

		// 초기화
		for (int i = 97; i <= 122; i++) {
			char temp = (char)i;
			strData.put(temp, 0);
		}
		for (int i =0; i < s.length(); i++) {
			int val = strData.get(s.charAt(i));
			strData.put(s.charAt(i), val + 1);
		}

		for (int i =0; i < t.length(); i++) {
			int val = strData.get(t.charAt(i));
			strData.put(t.charAt(i), val - 1);
		}

		for (Character key: strData.keySet()) {
			if (strData.get(key) != 0) return false;
		}

		return true;
	}


	/*
	* 단순 애너그램 -> 정렬 후 비교
	*
	* */
	class Solution {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length()) {
				return false;
			}
			char[] str1 = s.toCharArray();
			char[] str2 = t.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			return Arrays.equals(str1, str2);
		}
	}
}
