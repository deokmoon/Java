package com.leetcode.listnode;

import com.leetcode.listnode.common.ListNode;

public class RemoveElements203 {
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		/*
		* 첫 노드의 값부터 제거 값인 경우
		* */
		while(head != null) {
			if(head.val ==  val) {
				head = head.next;
			} else{
				break;
			}
		}

		/*
		* 얕은 복사를 해서 연결된 노드들의 값을 찾음
		 */
		ListNode p = head;

		if(p == null) return head;
		while(p.next != null) {
			if(p.next.val == val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}

		return head;
	}
}
