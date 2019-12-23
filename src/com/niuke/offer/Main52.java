package com.niuke.offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Main52 {
    public static void main(String[] args) {
        Main52 main52 = new Main52();
        System.out.println( main52.match("".toCharArray(),".*".toCharArray()));
        System.out.println( main52.match("".toCharArray(),".".toCharArray()));
        System.out.println( main52.match("aaa".toCharArray(),"ab*ac*a".toCharArray()));
        System.out.println( main52.match("aaa".toCharArray(),"aa.a".toCharArray()));
        System.out.println( main52.match("aaaasddsafaaa".toCharArray(),"adasdaa.a".toCharArray()));
    }

    /**
     * 参考代码
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }
    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检查:str到尾，pattern到尾，匹配成功
        if(strIndex == str.length && patternIndex == pattern.length)
            return true;
        //如果pattern先匹配到末尾，匹配失败
        if(strIndex != str.length && patternIndex == pattern.length)
            return false;
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if(patternIndex+1 < pattern.length && pattern[patternIndex+1] =='*'){
            if((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')){
                return matchCore(str,strIndex,pattern,patternIndex+2) //模式后移两位，相当于x*被忽略，即x*匹配0个字符
                        || matchCore(str,strIndex+1,pattern,patternIndex+2) //匹配中一个字符，字符串后移1为，模式后移两位
                        || matchCore(str,strIndex+1,pattern,patternIndex); //匹配一个，在匹配str中的下一个字符，因为*可以匹配多个字符
            }else{
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')){
            return matchCore(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }

    //TODO 存在数组越界等非法访问情况
    public boolean match2(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchByIndex(str, 0, pattern, 0);
    }

    private boolean matchByIndex(char[] str, int i, char[] pattern, int j) {
        /*if (str.length <= i && pattern.length > j) {
            return false;
        }*/
        if(str.length > i && pattern.length == j){
            return false;
        }
        if (str.length <= i && pattern.length <= j) {
            return true;
        }
        if (str.length > i && str[i] == pattern[j]) {
            if (j + 1 < pattern.length && pattern[j + 1] == '*') {
                return matchByIndex(str, i + 1, pattern, j) || matchByIndex(str, i + 1, pattern, j + 2);
            } else {
                return matchByIndex(str, i + 1, pattern, j + 1);
            }
        } else {
            if (pattern[j] == '.') {
                if (j + 1 < pattern.length && pattern[j + 1] == '*') {
                    return matchByIndex(str, i, pattern, j + 2) || matchByIndex(str, i + 1, pattern, j + 2) || matchByIndex(str, i + 1, pattern, j);
                } else {
                    return matchByIndex(str, i + 1, pattern, j + 1);
                }
            }
            if(j+1<pattern.length && pattern[j+1] == '*'){
                return matchByIndex(str, i, pattern, j + 2) || matchByIndex(str, i + 1, pattern, j + 2) || matchByIndex(str, i + 1, pattern, j);
            }
        }
        return false;
    }
}
