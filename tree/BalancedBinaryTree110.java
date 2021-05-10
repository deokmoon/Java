package com.leetcode.tree;
import com.leetcode.tree.common.TreeNode;

/*
* 최종적인 불리언 값을 얻는 것이 포인트
* 양방향으로 만 있는 트리 A 모양 등 고려해야 함
* */
public class BalancedBinaryTree110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int left = 0;
		int right = 0;

		left = solve(root.left, 1);
		right = solve(root.right, 1);

		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	public int solve(TreeNode node, int depth) {
		if (node == null) return depth;
		return Math.max(solve(node.left, depth + 1), solve(node.right, depth + 1));
	}
}

//class Solution {
//	public boolean isBalanced(TreeNode root) {
//		if (root == null) { return true; }
//		int left = depth(root.left);
//		int right = depth(root.right);
//		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//	}
//
//	private int depth(TreeNode root) {
//		if (root == null) { return 0; }
//		return Math.max(depth(root.left), depth(root.right)) + 1;
//	}
//}