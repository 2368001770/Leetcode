package com.niuke.offer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */



/**
 * 当快慢指针相遇的时候：
 *
 * 此时慢指针走的路程为Sslow = x + m * c + a
 * 快指针走的路程为Sfast = x + n * c + a
 * 2 Sslow = Sfast
 * 2 * ( x + m*c + a ) = (x + n *c + a)
 * 从而可以推导出：
 * x = (n - 2 * m )*c - a
 * = (n - 2 *m -1 )*c + c - a
 * 即环前面的路程 = 数个环的长度（为可能为0） + c - a
 */
public class Main55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {         //快慢指针，找到相交节点，然后两个指针分别从头节点和相交节点以相同的速度遍历，再次相交即为链表的环入口那个节点
        if(pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while(slow.next != null && fast.next != null && fast.next.next != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == slow){
            slow = pHead;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}

