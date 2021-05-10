package com.leetcode.listnode;

import com.leetcode.listnode.common.ListNode;

public class DeleteNode237 {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
