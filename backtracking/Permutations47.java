package com.leetcode.backtracking;

public class Permutations47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), new boolean[nums.length], nums);

        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> permutation, boolean[] visited, int[] nums) {
        if(permutation.size() == nums.length) {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            //==중복제거를 위한 조건문. 1a는 처리한 상태에서 1b가 나오면 또다시 탐색하지 않기 위함==//
            if(i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;

            visited[i] = true;
            permutation.add(nums[i]);

            dfs(res, permutation, visited, nums);

            permutation.remove(permutation.size() - 1);
            visited[i] = false;

        }
    }
}
