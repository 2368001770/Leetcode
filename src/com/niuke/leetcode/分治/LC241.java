package com.niuke.leetcode.分治;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output : [0, 2]
 */
public class LC241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l : left){
                    for(int r : right){
                        switch (c){
                            case '+' :
                                ways.add(l+r);
                                break;
                            case '-' :
                                ways.add(l-r);
                                break;
                            case '*' :
                                ways.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if(ways.size()==0){
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
