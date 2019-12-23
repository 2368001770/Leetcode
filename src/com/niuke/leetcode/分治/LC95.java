package com.niuke.leetcode.分治;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class LC95 {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0){                           //若n不合法，返回的list里面应该为空，而不是有null元素
            return new ArrayList<>();
        }
        return generateSubTrees(1,n);
    }

    private List<TreeNode> generateSubTrees(int s,int e){
        List<TreeNode> res = new ArrayList<>();
        if(s>e){
            res.add(null);
            return res;
        }
        for(int i=s; i<=e; i++){
            List<TreeNode> left = generateSubTrees(s,i-1);
            List<TreeNode> right = generateSubTrees(i+1,e);
            for (TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
