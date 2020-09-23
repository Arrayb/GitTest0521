package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 225. 用队列实现栈
 */
public class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1) {//保留队列最后一位用于出栈
            top = q1.remove();
            q2.add(top);
        }
        q1.remove();//出栈
        //队列交换
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    // Returns whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        for (int i=0;i<6;i++){
            stack.push(i);
        }
        stack.peek();
        stack.pop();
    }
}
