package com.leetcode.tree.common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) {
		this.val = val;
	}
	public TreeNode(int val, TreeNode Left, TreeNode right) {
		this.val = val;
		this.left = Left;
		this.right = right;
	}
}
