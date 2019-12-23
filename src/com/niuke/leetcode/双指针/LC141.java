package com.niuke.leetcode.双指针;

/**
 * 判断链表是否存在环
 */
public class LC141 {
    public boolean hasCycle(ListNode head) {        //使用双指针，若快慢指针分别每次走一步和两步，若存在环则必相交
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}