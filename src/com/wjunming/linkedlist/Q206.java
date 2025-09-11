package com.wjunming.linkedlist;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/description/">206. 反转链表</a>
 */
public class Q206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
