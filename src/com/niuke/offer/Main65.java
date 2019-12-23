package com.niuke.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Main65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] booleans = new boolean[matrix.length];
        for(int i=0;i<matrix.length;i++){
            int x = i / cols;
            int y = i % cols;
            if(currHashPath(matrix,rows,cols,x,y,str,0,booleans)){
                return true;
            }
        }
        return false;
    }

    /**
     * 以当前位置开始搜索
     * @param matrix 数值矩阵
     * @param rows 行数
     * @param cols 列数
     * @param x 数值在矩阵中的x坐标
     * @param y 数值在矩阵中的y坐标
     * @param str 需要搜索的字符串
     * @param k 当前搜索到字符串下标
     * @param booleans 标记该位置是否已经走过，需要回溯
     * @return
     */
    private boolean currHashPath(char[] matrix,int rows,int cols,int x,int y,char[] str,int k,boolean[] booleans){
        int index = x*cols + y;
        if(k == str.length){
            return true;
        }
        if(x<0 || x>=rows || y<0 || y>=cols || matrix[index] != str[k] || booleans[index] == true){
            return false;
        }
        booleans[index] = true;
        if(currHashPath(matrix,rows,cols,x-1,y,str,k+1,booleans)
            || currHashPath(matrix,rows,cols,x+1,y,str,k+1,booleans)
            || currHashPath(matrix,rows,cols,x,y-1,str,k+1,booleans)
            || currHashPath(matrix,rows,cols,x,y+1,str,k+1,booleans)){
            return true;
        }
        booleans[index] = false;
        return false;
    }
}
