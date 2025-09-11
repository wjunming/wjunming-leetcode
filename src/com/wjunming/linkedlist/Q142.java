package com.wjunming.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">142. 环形链表 II</a>
 */
public class Q142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
