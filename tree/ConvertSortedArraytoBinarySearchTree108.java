package com.leetcode.tree;

import com.leetcode.tree.common.TreeNode;

public class ConvertSortedArraytoBinarySearchTree108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) return null;

		TreeNode root = makeNode(nums, 0, nums.length - 1);

		return root;
	}
	public TreeNode makeNode(int[] nums, int start, int end) {
		if (end < start) return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = makeNode(nums, start, mid - 1);
		node.right = makeNode(nums, mid + 1, end);

		return node;
	}
}
