package com.niuke.offer;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class Main66 {
    //ERROR 误解题目意思。机器人只能一格咯的走，不能跨越多个格，题目所述k=18时，(22,22)也不能到达,满足的位置应该连续
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] booleans = new boolean[rows][cols];
        return getMovingCount(threshold,rows,cols,0,0,booleans);
    }

    // ERROR 错误代码,没有满足所走路径连续的特点
   /* private int getMovingCount(int threshold,int rows,int cols,int i,int j,boolean[][] booleans){
        int count = 0;
        if(i<0 || i>=rows || j<0 || j>=cols){
            return count;
        }
        if(booleans[i][j]==false && (getNumSum(i)+getNumSum(j))<=threshold){            //ERROR当前格无法到达，那么也不能向下搜索了
            count++;
        }
        booleans[i][j] = true;
        return count + getMovingCount(threshold,rows,cols,i,j+1,booleans) + getMovingCount(threshold,rows,cols,i+1,j,booleans);
    }*/

    private int getMovingCount(int threshold,int rows,int cols,int i,int j,boolean[][] booleans){
        if(i<0 || i>=rows || j<0 || j>=cols || booleans[i][j]==true || (getNumSum(i)+getNumSum(j))>threshold){
            return 0;
        }

        booleans[i][j] = true;
        //往上或右搜索即可
        return 1 + getMovingCount(threshold,rows,cols,i,j+1,booleans) + getMovingCount(threshold,rows,cols,i+1,j,booleans);
    }

    private int getNumSum(int num){
        int sum = 0;
        while(num != 0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
}
