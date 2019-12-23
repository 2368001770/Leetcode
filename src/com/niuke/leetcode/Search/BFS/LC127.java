package com.niuke.leetcode.Search.BFS;

import java.util.*;

/**
 * 找出一条从 beginWord 到 endWord 的最短路径，每次移动规定为改变一个字符，并且改变之后的字符
 * 串必须在 wordList 中。
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int begin = wordList.size() - 1;
        int end = 0;
        for (String s : wordList){
            if(endWord.equals(s)){
                break;
            }
            end++;
        }
        if(end == wordList.size()){
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic,begin,end);
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            while(size-- > 0){
                int curr = queue.poll();
                if(curr == end){
                    return result;
                }
                for(int next : graphic[curr]){
                    if(!marked[next]){
                        queue.add(next);
                        marked[next] = true;
                    }
                }
            }
        }
        return 0;
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int length = wordList.size();
        List<Integer>[] graphic = new List[length];
        for(int i=0; i<wordList.size(); i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<wordList.size();j++){
                if(isConnect(wordList.get(i),wordList.get(j))){
                    list.add(j);
                }
            }
            graphic[i] = list;
        }
        return graphic;
    }

    public boolean isConnect(String m,String n){
        int cnt = 0;
        if(m == null || n == null || m.length() != n.length()){
            return false;
        }
        for(int i=0; i<m.length(); i++){
            if(m.charAt(i) != n.charAt(i)){
                cnt++;
            }
        }
        return cnt==1;
    }

    public static void main(String[] args) {
        LC127 lc127 = new LC127();
        System.out.println(lc127.ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
}
