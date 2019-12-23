package com.niuke.offer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入一个字符串,包括数字字母符号,可以为空
 */
public class Main49 {
    public int StrToInt(String str) {           //先单独判断第一个字符
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int sum = 0;
        boolean symbol = true;
        if(chars[0] == '-'){
            symbol = false;
        }else if(chars[0] == '+'){
            symbol = true;
        }else if(chars[0]-'0'>=0 && chars[0]-'0'<=9){
            sum = chars[0] - '0';
        }else {
            return 0;
        }
        for(int i=1;i<chars.length;i++){
            if(chars[i]-'0'>=0 && chars[i]-'0'<=9){
                sum = sum*10 + chars[i] - '0';
            }else {
                return 0;
            }
        }
        return symbol?sum:-sum;
    }
}
