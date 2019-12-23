package com.niuke.offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Main15 {
    public ListNode ReverseList(ListNode head) {        //递归
        if(head == null || head.next == null){    //WARN 注意条件判断
            return head;
        }
        ListNode next = head.next;
        ListNode node = ReverseList(next);
        next.next = head;                       //WARN 注意空指针异常
        head.next = null;                       //WARN 运行超时
        return node;
    }

    public ListNode ReverseList2(ListNode head) {        //迭代，头插法
        ListNode temp = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return temp.next;
    }
}
