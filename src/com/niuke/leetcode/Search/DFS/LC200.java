package com.niuke.leetcode.Search.DFS;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 */
public class LC200 {

    private int m, n;
    private int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int islandNums = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    islandNums++;
                }
            }
        }
        return islandNums;
    }

    private void dfs(char[][] grid,int r,int c){
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] dire : direction){
            dfs(grid,r+dire[0],c+dire[1]);
        }
    }
}
