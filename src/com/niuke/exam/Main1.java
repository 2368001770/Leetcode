package com.niuke.exam;

import java.util.*;

/**
 * 度小满笔试题
 *
 * 你现在在(0,0)，需要到(x,y)去，路上有n个障碍物。(-500~500)
 * 给出每个障碍物的坐标，你只能平行于坐标轴走整数步，问你最少需要多少步才能走到目的地。
 */
public class Main1 {

    /**
     * BFS 注意存储遍历到当前位置的步数
     * 由于横纵坐标都可能为负数,可用队列存储横纵坐标和到当前位置的步数(也可以建立一个类来直接存储这三个值)
     * 需要对障碍位置和已经遍历的位置做标识,可以用list集合存储,也可以用数组,但是用数组需要转化坐标(下标不为负数)
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int count = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(scanner.nextInt());
            list.add(scanner.nextInt());
        }
        list.add(0);
        list.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(0);
        queue.offer(0);
        int result = 0;
        while(result==0 && !queue.isEmpty()){
            int i = queue.poll();
            int j = queue.poll();
            list.add(i);
            list.add(j);
            int step = queue.poll();
            if(i==x&&j==y){
                result = step;
            }
            if(isRun(list,i,j+1)){
                queue.offer(i);
                queue.offer(j+1);
                queue.offer(step+1);
            }
            if(isRun(list,i,j-1)) {
                queue.offer(i);
                queue.offer(j - 1);
                queue.offer(step+1);
            }
            if(isRun(list,i-1,j)) {
                queue.offer(i - 1);
                queue.offer(j);
                queue.offer(step+1);
            }
            if(isRun(list,i+1,j)){
                queue.offer(i+1);
                queue.offer(j);
                queue.offer(step+1);
            }
        }
        System.out.println(result);
    }

    private static boolean isRun(List<Integer> list,int x,int y){
        for(int i=0;i<list.size();i=i+2){
            if(list.get(i)==x&&list.get(i+1)==y){
                return false;
            }
        }
        return true;
    }
}


/**   参考代码
 *    作者：pdun122
 *    链接：https://www.nowcoder.com/discuss/259962?type=0&order=0&pos=26&page=1
 *    来源：牛客网
 */
class Node{
    public int x;
    public int y;
    public int step;

    public Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

 class Main{
    private static final int MAX = 1005;
    private static final int BASE = 500;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean[][] visited = new boolean[MAX][MAX];
        int x = scanner.nextInt() + BASE;
        int y = scanner.nextInt() + BASE;
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int px = scanner.nextInt() + BASE;
            int py = scanner.nextInt() + BASE;
            visited[px][py] = true;
        }
        scanner.close();

        System.out.println(bfs(visited, x, y));
    }

    private static int bfs(boolean[][] visited, int ex, int ey){
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        visited[BASE][BASE] = true;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(BASE, BASE, 0));

        while (!queue.isEmpty()){
            Node node = queue.pollFirst();

            for(int[] dir : dirs){
                int x = node.x + dir[0];
                int y = node.y + dir[1];

                if(x < 0 || x > MAX || y < 0 || y > MAX)
                    continue;

                if(visited[x][y])
                    continue;

                if(x == ex && y == ey)
                    return node.step + 1;

                visited[x][y] = true;
                queue.add(new Node(x, y, node.step + 1));
            }
        }

        return -1;
    }

}
