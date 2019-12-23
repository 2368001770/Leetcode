package com.niuke.offer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Main56 {

    public ListNode deleteDuplication(ListNode pHead) {         //非递归（考虑头节点开始重复还是其他节点开始重复的情况）
        if(pHead == null){
            return null;
        }
        while(pHead != null && pHead.next != null && pHead.val == pHead.next.val){
            while (pHead != null && pHead.next != null && pHead.val == pHead.next.val){
                pHead = pHead.next;
            }
            pHead = pHead.next;
        }
        ListNode pre = pHead;
        ListNode cur = pHead;
        if(pHead != null){
            cur = pHead.next;
        }

        while(cur != null){
            int repCount = 1;
            while(cur != null && cur.next!= null && cur.val==cur.next.val){
                repCount++;
                cur = cur.next;
            }
            if (repCount > 1){
                pre.next = cur.next;                // 出现重复，处理完重复的节点后pre指针不变
            }else {
                pre = pre.next;                     //没有出现重复，pre指针向后移动一位
            }
            cur = cur.next;
        }
        return pHead;
    }

    public ListNode deleteDuplication2(ListNode pHead) {                 //递归(考虑当前节点是否会重复)
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        if(pHead.val != pHead.next.val){
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }else {
            while(pHead != null && pHead.next != null && pHead.val == pHead.next.val){
                pHead = pHead.next;
            }
            pHead = pHead.next;
            return deleteDuplication2(pHead);
        }
    }
}
