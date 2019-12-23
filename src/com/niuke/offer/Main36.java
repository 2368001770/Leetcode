package com.niuke.offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Main36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {             //先计算两个链表的长度差diff，让较长的链表先走diff，再一起走
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int length1 = 0,length2 = 0;
        ListNode temp1 = pHead1,temp2 = pHead2;                             // WARN 求长度用临时指针遍历而不用入参头指针，因为便利后指针指向null，会有空指针异常
        while(temp1 != null){
            length1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            length2++;
            temp2 = temp2.next;
        }
        int diff = length1 - length2;
        if(diff > 0){
            while(diff-- > 0){
                pHead1 = pHead1.next;
            }
        }else {
            while(diff++ < 0){
                pHead2 = pHead2.next;
            }
        }
        while(pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {            //两个链表同时出发，若结束则重新从另一个链表出发，直到相等
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1,p2 = pHead2;
        while(p1 != p2){                            //WARN 若有交点，在交点处相等，若无交点，在链表结尾处相等，均为null
            if(p1 == null){
                p1 = pHead2;
            }else {
                p1 = p1.next;
            }
            if(p2 == null){
                p2 = pHead1;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    /**
     * 错误代码，若链表1与链表2的相遇节点为链表2的头节点，使链表1在进行到null后，
     * 下一次遍历转到链表2的头节点再进行一次next操纵，再对两个指针进行比较，只能得到相遇节点的后一个节点
     */
    /*public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1,p2 = pHead2;
        while(p1 != p2){
            if(p1 == null){
                p1 = pHead2;
            }
            if(p2 == null){
                p2 = pHead1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }*/


    /**
     * 错误代码，若无交点出现死循环（已经改变结尾的null指针，使其永不相等了）
     */
    /*public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1,p2 = pHead2;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == null){
                p1 = pHead2;
            }
            if(p2 == null){
                p2 = pHead1;
            }
        }
        return p1;
    }*/


    /**
     * 错误代码，使用pHead1遍历时，pHead1已经不再是指向链表的头节点，重新遍历会出错
     * 应当用另一个临时指针进行遍历
     */
    /*public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        while(pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
            if(pHead1 == null){
                pHead1 = pHead2;
            }
            if(pHead2 == null){
                pHead2 = pHead1;
            }
        }
        return pHead1;
    }*/
}
