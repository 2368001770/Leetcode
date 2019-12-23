package com.niuke.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Main14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null){               //WARN 入参判断
            return null;
        }
        ListNode temp = head;
        while(temp!=null && k-->0){     //WARN
            temp=temp.next;
        }
        if(k>0){                         //WARN 判断k是否大于链表的长度
            return null;
        }
        while(temp!=null){
            temp=temp.next;
            head=head.next;
        }
        return head;
    }
}
