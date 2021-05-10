package com.leetcode.tree;

import com.leetcode.tree.common.TreeNode;

public class MaximumDepthOfBinaryTree104 {
	public int maxDepth(TreeNode root) {
		return solve(root, 0);
	}
	public int solve(TreeNode node, int depth) {
		if(node == null) return  depth;
		return Math.max(solve(node.left,  depth + 1), solve(node.right, depth + 1));
	}
}
