package com.leetcode.linkedList;

/**
 * 2021.03.16
 * 직접 리스트 노드를 만들어 푸는 것이 효율적
 *
 * 매개변수가 3개인 생성자로 Node 생성 시 신규 객체가 head가 되며 기존 생성된 head가 head의 Next가 됨
 *
 */
public class MinStack155 {
    private Node head;

    public void push(int x) {
        if(head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }



    /**
     * ArrayList를 활용하여 푼 방식
     */
    /*
    private ArrayList<Integer> stack = new ArrayList<>();
    private ArrayList<Integer> minStack = new ArrayList<>();

    public MinStack() {

    }

    public void push(int x) {
        minStack.add(x);
        stack.add(x);
        Collections.sort(minStack);
    }

    public void pop() {
        if(stack.get(stack.size() - 1).equals(minStack.get(0))) {
            minStack.remove(0);
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        // System.out.println("minStack: " + minStack);
        // System.out.println("stack: " + stack);
        return minStack.get(0);
    }
    */
}
