package com.niuke.leetcode.Search.DFS;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class LC130 {

    private int m, n;
    private int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int j=0; j<n; j++){
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c){
        if(r<0 || r>=m || c<0 || c>=n || board[r][c]!='O'){
            return;
        }
        board[r][c] = 'T';
        for(int[] dire : direction){
            dfs(board, r+dire[0], c+dire[1]);
        }
    }
}
