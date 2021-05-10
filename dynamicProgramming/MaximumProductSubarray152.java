package com.leetcode.dynamicProgramming;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        // kadane 알고리즘
        int min = nums[0];
        int max = nums[0];
        int curr = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int tempMin = min;
            min = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            max = Math.max(nums[i], Math.max(tempMin * nums[i], max * nums[i]));

            System.out.println("i: " + i);
            System.out.println(" min is "+ min +" max is "+ max);
            if(max > curr){
                System.out.println("updating current as "+ max +" on idx "+ i + "\n");
                curr = max;
            }
        }
        return curr;
    }
}
