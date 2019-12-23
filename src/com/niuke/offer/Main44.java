package com.niuke.offer;

public class Main44 {
    public static void main(String[] args) {
        Main44 main44 = new Main44();
        System.out.println(" ".trim() == "");                   // WARN false
        System.out.println(" ".trim().length());                // 0
        System.out.println(" ".trim().equals(""));              // true
        System.out.println("  ".split(" ").length);      // 0
        main44.ReverseSentence(" ");
    }
    public String ReverseSentence(String str) {                 //字符串分割成多个单词，对每个单词进行翻转
        if(str == null || str.length() == 0 || str.trim().equals("")){
            return str;
        }
        String[] strings = str.split(" ");              //WARN 注意入参为“   ”这种情况
        int start = 0,end = strings.length - 1;
        while(start < end){
            String temp = strings[start];
            strings[start] = strings[end];
            strings[end] = temp;
            start++;
            end--;
        }
        StringBuilder builder = new StringBuilder();
        for(String string : strings){
            builder.append(string);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public String ReverseSentence2(String str) {                         //先对整个字符串进行翻转，再对每个单词进行翻转
        if(str == null || str.trim().length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        reverse(chars,0,length-1);
        int preIndex = -1,sufIndex = 0;
        for(char ch : chars){
            if(ch == ' '){                                              //WARN 字符类型：‘ ’,字符串类型：“ ”
                reverse(chars,preIndex+1,sufIndex-1);
                preIndex = sufIndex;
            }
            sufIndex++;
        }
        reverse(chars,preIndex+1,length-1);
        return new String(chars);
    }

    private void reverse(char[] chars,int start,int end){
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
