package com.hackerRank;

import java.util.List;

public class JumpingOnTheClouds {
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here

        return getJumpsCount(c, 0, 0);
    }

    public static int getJumpsCount(List<Integer> c, int index, int count) {
        if(index >= c.size()) return count;
        int res1 = 0, res2 = 0;

        if(c.get(index) == 1) res1 = getJumpsCount(c, index + 1, count);
        else res2 = Math.min(getJumpsCount(c, index + 1, count++), getJumpsCount(c, index + 2, count++));

        

        return Math.min(res1, res2);
    }
}
