package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class LC51 {

    private List<List<String>> solutions;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] diagonaIs45Used;
    private boolean[] diagonaIs135Used;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(nQueens[i],'.');
        }
        colUsed = new boolean[n];
        diagonaIs45Used = new boolean[2 * n - 1];
        diagonaIs135Used = new boolean[2 * n - 1];
        this.n = n;
        backtracking(0);
        return solutions;
    }

    private void backtracking(int row) {
        if(row == n){
            List<String> list = new ArrayList<>();
            for(char[] chars: nQueens){
                list.add(new String(chars));
            }
            solutions.add(list);
            return;
        }
        for(int col=0; col<n; col++){
            int diagonals45Idx = row + col;
            int diagonals135Idx = n - 1 - (row - col);
            if(colUsed[col] || diagonaIs45Used[diagonals45Idx] || diagonaIs135Used[diagonals135Idx]){
                continue;
            }
            nQueens[row][col] = 'Q';
            colUsed[col] = diagonaIs45Used[diagonals45Idx] = diagonaIs135Used[diagonals135Idx] = true;
            backtracking(row + 1);
            nQueens[row][col] = '.';
            colUsed[col] = diagonaIs45Used[diagonals45Idx] = diagonaIs135Used[diagonals135Idx] = false;
        }
    }
}
