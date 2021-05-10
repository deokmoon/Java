package com.leetcode.listnode;

import com.leetcode.listnode.common.ListNode;

import java.util.ArrayList;

public class ReverseLinkedList206 {
	public ListNode reverseList(ListNode head) {
		if(head == null) return head;

		ArrayList<Integer> store = new ArrayList<>();
		ListNode p = head;
		store.add(head.val);
		while(p.next != null) {
			store.add(p.next.val);
			p = p.next;
		}

		ListNode resNode = new ListNode(store.get(store.size() - 1));
		p = resNode;
		for(int i = store.size() - 2; i >= 0; i--) {
			p.next = new ListNode(store.get(i));
			p = p.next;
		}

		return resNode;
	}
	/*
	* 아래는 리트코드 답
	*   - 레퍼런스를 temp 활용하여 Swap하는 방식
	*   -
	* */
	public ListNode reverseListSolution(ListNode head) {
		ListNode prev = null; // 최종적으로 만들 노드리스트
		ListNode curr = head; // 주어진 노드리스트를 탐색하는 노드리스트
		while (curr != null) {
			ListNode nextTemp = curr.next; // 현재노드의 다음 노드리스트를 템프노드에 담음 (마지막에 curr로 다시 세팅을 위함)
			curr.next = prev; // 현재 노드의 다음은 prev로 지정(레퍼런스 반대로 하기 위함)
			prev = curr; // 현재 노드(curr)는 처리한 것이므로 prev로 레퍼런스 -> prev는 curr이 레퍼런스를 수정한 방향의 노드들을 가짐
			curr = nextTemp; // curr은 임시 저장해놓은 다음 대상의 노드들로 세팅
		}
		return prev;
	}
}
