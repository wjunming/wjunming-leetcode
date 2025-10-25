package com.wjunming.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.cn/problems/min-stack/description/">155. 最小栈</a>
 */
public class Q155 {

    class MinStack {

        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack2 {

        private final Deque<int[]> stack;

        public MinStack2() {
            stack = new LinkedList<>();
            stack.push(new int[]{0, Integer.MAX_VALUE});
        }

        public void push(int val) {
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
