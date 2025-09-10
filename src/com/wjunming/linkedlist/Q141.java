package com.wjunming.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle/description/">141. 环形链表</a>
 */
public class Q141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
