package com.niuke.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Main53 {
    public boolean isNumeric(char[] str) {              //正则表达式
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([Ee][\\+\\-]?\\d+)?");
    }


    int index = 0;                                      //用index标记位置，依次遍历
    public boolean isNumeric2(char[] str) {
        if(str.length < 1){
            return false;
        }
        boolean flag = scanInteger(str);
        if(index < str.length && str[index] == '.'){
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if(index < str.length && (str[index] == 'E' || str[index] == 'e')){
            index++;
            flag = flag && scanInteger(str);
        }
        return flag && str.length == index;
    }

    private boolean scanInteger(char[] chars){
        if(index < chars.length &&(chars[index] == '+' || chars[index] == '-')){
            index++;
        }
        return scanUnsignedInteger(chars);
    }

    private boolean scanUnsignedInteger(char[] chars){
        int start = index;
        while(index < chars.length && (chars[index] >= '0' && chars[index] <= '9')){
            index++;
        }
        return index>start;
    }
}
