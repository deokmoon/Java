package com.hackerRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class First implements Comparable<HashMap<Integer, Integer>> {
    /*
     * Complete the 'cardinalitySort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY nums as parameter.
     */
    public static HashMap<Integer, Integer> bitCountMap = new HashMap<>();

    public static List<Integer> cardinalitySort(List<Integer> nums) {
        // Write your code here
        int length = nums.size();
        makeBitCountMap(nums, length);

        return nums;
    }

    public static int countRemainder(int nums) {
        int count = 0;

        while(nums > 0) {
            if(nums % 2 == 1) count++;
            nums = nums / 2;
        }

        return count;
    }

    public static void makeBitCountMap(List<Integer> nums, int length) {

        for(int i = 0; i< length; i++) {
            if(!bitCountMap.containsKey(nums.get(i))) bitCountMap.put(nums.get(i), countRemainder(nums.get(i)));
        }

        setSortVal(nums, bitCountMap, length);
    }

    public static void setSortVal(List<Integer> nums, HashMap<Integer, Integer> bitCountMap, int length) {
        int key, val;
        int i, j;
        for(i = 1; i < length; i++) {
            key = nums.get(i);
            val = bitCountMap.get(key);

            for(j = i - 1; j >= 0; j--) {
                if(bitCountMap.get(nums.get(j)) >= val) {
                    if(bitCountMap.get(nums.get(j)) == val && nums.get(j) > key) nums.set(j + 1, nums.get(j));
                    else if(bitCountMap.get(nums.get(j)) > val) nums.set(j + 1, nums.get(j));
                    else break;
                }
                else break;
            }
            nums.set(j + 1, key);
        }
    }

    @Override
    public int compareTo(HashMap<Integer, Integer> o) {
        for(Map.Entry<Integer, Integer> entry: bitCountMap.entrySet()) {

        }


        return 0;
    }
}
