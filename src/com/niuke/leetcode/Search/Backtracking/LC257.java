package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        if(node == null){
            return;
        }
        values.add(node.val);
        if(isLeaf(node)){
            paths.add(buildPath(values));
        }else {
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        values.remove(values.size()-1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<values.size(); i++){
            str.append(values.get(i));
            if(i != values.size() - 1){
                str.append("->");
            }
        }
        return str.toString();
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

