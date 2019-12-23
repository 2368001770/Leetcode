package com.niuke.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Main20 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> satck2 = new Stack<>();

    Stack<Integer> stack = new Stack<>();

    public void push(int node) {        //两个栈实现
        if(satck2.isEmpty()){
            satck2.push(node);
        }else {
            if (satck2.peek() >= node) {
                satck2.push(node);
            } else {
                satck2.push(satck2.peek());
            }
        }
        stack1.push(node);
    }

    public void pop() {
        stack1.pop();
        satck2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return satck2.peek();
    }


    /**
     * 一个栈实现
     * @param node
     */
    public void push2(int node) {
        if(stack.isEmpty()){
            stack.push(node);
            stack.push(node);
        }else {
            Integer min = stack.peek();
            if(node <= min){
                stack.push(node);
                stack.push(node);
            } else {
                stack.push(node);
                stack.push(min);
            }
        }
    }

    public void pop2() {
        stack.pop();
        stack.pop();
    }

    public int top2() {
        return stack.get(stack.size()-2);
    }

    public int min2() {
      return stack.peek();
    }
}
