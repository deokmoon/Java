package com.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber136 {
	public int singleNumber(int[] nums) {
		if (nums.length == 1) return nums[0];
		int res = 0;
		Arrays.sort(nums);
		if (nums[0] != nums[1]) return nums[0];

		for (int i = 0; i < nums.length; i = i + 2) {
			if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
				res = nums[i];
				break;
			}
		}
		return res;
	}
}
/*
* @Author LeetCode
*
* HashTable(HashMap) 의 getOrDefault 메소드 사용

*
* */
class Solution {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> hash_table = new HashMap<>();

		for (int i : nums) {
			hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
		}
		for (int i : nums) {
			if (hash_table.get(i) == 1) {
				return i;
			}
		}
		return 0;
	}
}