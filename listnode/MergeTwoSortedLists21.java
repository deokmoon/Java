package com.leetcode.listnode;

import com.leetcode.listnode.common.ListNode;

public class MergeTwoSortedLists21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null  && l2 != null) return l2;
		if(l1 != null  && l2 == null) return l1;
		if(l1 == null  && l2 == null) return null;

		ListNode res = null;

		if(l1.val <= l2.val) res = sol(l1, l2);
		else res = sol(l2, l1);

		return res;
	}

	public ListNode sol(ListNode l1, ListNode l2) { // l1을 기준으로 l2를 붙이는 방식
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		ListNode temp = null;
		while(curr1.next != null && curr2 != null) {
			if(curr1.next.val > curr2.val) {
				temp = curr1.next;
				curr1.next = curr2;
				curr2 = curr2.next;
				curr1.next.next = temp;
			} else {
				curr1 = curr1.next;
			}
		}
		temp = l1;
		while(curr1.next == null && curr2 != null) {
			if(temp.next == null) {
				temp.next = curr2;
				break;
			}
			else temp = temp.next;
		}

		return l1;
	}
}
