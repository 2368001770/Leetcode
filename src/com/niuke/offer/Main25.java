package com.niuke.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Main25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode temp = pHead;
        while(temp != null){
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        RandomListNode temp2 = pHead;
        while(temp2 != null){
            RandomListNode randomNode = temp2.random;
            if(randomNode != null){                                 //WRAN 注意randomNode可能为空的情况
                temp2.next.random = randomNode.next;
            }
            temp2 = temp2.next.next;
        }
        RandomListNode temp3 = pHead;
        RandomListNode newHead = pHead.next;
        while(temp3 != null && temp3.next != null){
            RandomListNode next = temp3.next;
            temp3.next = next.next;
            temp3 = next;
        }
        return newHead;
    }
}



class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}