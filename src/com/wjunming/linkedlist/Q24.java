package com.wjunming.linkedlist;

/**
 * @see <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/">24. 两两交换链表中的节点</a>
 */
public class Q24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next, node2 = p.next.next;
            p.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            p = node1;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmpNode = head.next;
        head.next = swapPairs2(tmpNode.next);
        tmpNode.next = head;
        return tmpNode;
    }
}
