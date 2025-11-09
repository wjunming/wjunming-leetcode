package com.wjunming.linkedlist;

/**
 * @see <a href="https://leetcode.cn/problems/design-circular-deque/">641. 设计循环双端队列</a>
 */
public class Q641 {

    /**
     * 双向链表
     */
    class MyCircularDeque1 {

        private DListNode head;
        private DListNode tail;
        private final int capacity;
        private int size;

        public MyCircularDeque1(int k) {
            capacity = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            DListNode node = new DListNode(value);
            if (isEmpty()) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            DListNode node = new DListNode(value);
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return head.val;
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return capacity == size;
        }
    }

    /**
     * 数组
     */
    class MyCircularDeque2 {

        private int[] data;
        private int capacity;
        private int head;
        private int tail;

        public MyCircularDeque2(int k) {
            capacity = k + 1;
            data = new int[capacity];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head - 1 + capacity) % capacity;
            data[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            data[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return data[head];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return data[(tail - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (tail + 1) % capacity == head;
        }
    }
}
