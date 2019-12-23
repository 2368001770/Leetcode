package com.niuke.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Main3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {      //递归
        if(listNode == null) return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(printListFromTailToHead(listNode.next));
        arrayList.add(listNode.val);
        return arrayList;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {     //头插法
        ListNode head = new ListNode(-1);
        while(listNode != null){
            ListNode next = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {     //使用栈
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
