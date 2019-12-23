package com.niuke.leetcode.Search.Backtracking;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 */
public class LC37 {

    private boolean[][] rowUsed = new boolean[9][10];
    private boolean[][] columnUsed = new boolean[9][10];
    private boolean[][][] blockUsed = new boolean[3][3][10];

    public void solveSudoku(char[][] board) {
        int num;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                num = board[i][j] - '0';
                rowUsed[i][num] = true;
                columnUsed[j][num] = true;
                blockUsed[i/3][j/3][num] = true;
            }
        }
        solve(board,0);
    }

    private boolean solve(char[][] board, int pos) {
        int row = pos / 9;
        int column = pos % 9;
        if(pos > 80){
            return true;
        }
        if(board[row][column] != '.'){
            return solve(board, pos+1);
        }
        for(int num=1; num<10; num++){
            if(rowUsed[row][num] || columnUsed[column][num] || blockUsed[row/3][column/3][num]){
                continue;
            }
            rowUsed[row][num] = columnUsed[column][num] = blockUsed[row/3][column/3][num] = true;
            board[row][column] = (char) ('0' + num);
            if(solve(board, pos+1)){
                return true;
            }else {
                board[row][column] = '.';
                rowUsed[row][num] = columnUsed[column][num] = blockUsed[row/3][column/3][num] = false;
            }
        }
        return false;
    }
}
