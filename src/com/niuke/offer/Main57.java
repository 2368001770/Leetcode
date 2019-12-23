package com.niuke.offer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Main57 {
    //只需考虑pNode是否有右节点，若有右节点则找出右子树中最左的节点，
    // 若无右节点则找其父亲节点（需判断其父亲节点是否已经被遍历，一直往上查找）
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode != null && pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            TreeLinkNode parrent = pNode.next;
            while(parrent != null && parrent.left != pNode){
                parrent = parrent.next;
                pNode = pNode.next;
            }
            return parrent;
        }
    }
}
