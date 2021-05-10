package com.leetcode.hashtable;

import java.util.HashMap;

/**
 * 2021.03.16
 * HashTable을 사용하면 O(nlogN) ~ O(n)으로 처리 가능
 * hashmap은 worst case인 경우 collision 발생할 수 있으므로
 *
 * map의 key는 nums의 값 / value는 nums의 index가 담긴다.
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
