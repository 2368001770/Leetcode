package com.niuke.offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Main61 {                           // WARN

    String Serialize(TreeNode root) {           //先序遍历序列化
        if(root == null){
            return "#!";                        // WARN 节点为空也需要加分隔符，方便反序列化字符分割
        }
        return root.val + "!" + Serialize(root.left) + Serialize(root.right);
    }

    int index = -1;                             //WARN 用index标记当前节点下标
    TreeNode Deserialize(String str) {
        String[] string = str.split("!");
        index++;
        if(string[index].equals("#")){                  //ERROR 注意用equals而不用==（字符串比较尽量用equals）
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(string[index]));
        node.left = Deserialize(str);
        node.right = Deserialize(str);
        return node;
    }
}
