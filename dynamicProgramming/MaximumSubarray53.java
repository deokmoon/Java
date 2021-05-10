package com.leetcode.dynamicProgramming;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int cMax = nums[0];
        int oMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            cMax = Math.max(cMax + nums[i], nums[i]);
            oMax = Math.max(cMax, oMax);
        }

        return oMax;
    }
}
