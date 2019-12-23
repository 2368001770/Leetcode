package com.niuke.offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Main16 {
    public ListNode Merge(ListNode list1, ListNode list2) {             //递归
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode head = null;
        if(list1.val<list2.val){
            head = list1;
            list1 = list1.next;
        }else {
            head = list2;
            list2 = list2.next;
        }
        head.next = Merge(list1,list2);
        return head;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {            //迭代
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 == null){
            temp.next = list2;
        }
        if(list2 == null){
            temp.next = list1;
        }
        return head.next;
    }
}
