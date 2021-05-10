package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);

        return res;
    }

    public void dfs(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> res) {
        if(visited.length == path.size()) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;

            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, path, visited, res);

            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
  