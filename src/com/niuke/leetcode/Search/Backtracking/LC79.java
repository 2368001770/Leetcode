package com.niuke.leetcode.Search.Backtracking;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class LC79 {

    private static final int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(backtracking(0, i, j, hasVisited, board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(int curLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
        if(word.length() == curLen){
            return true;
        }
        if(r<0 || r>=m || c<0 || c>=n || visited[r][c] || board[r][c]!=word.charAt(curLen)){
            return false;
        }
        visited[r][c] = true;
        for(int[] d : direction){
            if(backtracking(curLen+1, r+d[0], c+d[1], visited, board, word)){
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
