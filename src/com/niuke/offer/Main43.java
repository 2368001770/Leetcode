package com.niuke.offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Main43 {
    public static void main(String[] args) {
        Main43 main43 = new Main43();
        System.out.println(main43.LeftRotateString("",6));
    }
    public String LeftRotateString(String str,int n) {              // 在原字符串中截取
        int length = str.length();
        if(length == 0){
            return str;
        }
        int m = n % length;                             //WARN 若str为空字符串，则length为0，会抛出ArithmeticException（故应提前判断长度是否为0）
        String prefix = str.substring(0,m);
        String siffix = str.substring(m);
        return siffix + prefix;
    }

    public String LeftRotateString3(String str,int n) {          //先把原来的字符串进行拼接再截取
        int length = str.length();
        if(length == 0){
            return str;
        }
        int m = n % length;
        String newStr = str + str;
        return newStr.substring(m,m+length);
    }

    public String LeftRotateString2(String str,int n) {                         //先把前面的翻转，再把后面的翻转，最后把整个翻转
        int length = str.length();
        if(length == 0){
            return str;
        }
        int m = n % length;
        char[] chars = str.toCharArray();
        reverse(chars,0,m-1);
        reverse(chars,m,length-1);
        reverse(chars,0,length-1);
        return new String(chars);
    }

    private void reverse(char[] chars,int start,int end){
        while(start < end){
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }
}
