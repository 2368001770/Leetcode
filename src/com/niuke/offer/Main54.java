package com.niuke.offer;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Main54 {

    int[] charsCount = new int[256];                        // WARN 记录每个字符出现的次数
    StringBuilder stringBuilder = new StringBuilder();      // WARN 记录每个字符出现的顺序

    //Insert one char from stringstream
    public void Insert(char ch) {
        charsCount[ch]++;
        stringBuilder.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        String str = stringBuilder.toString();
        for (int i=0;i<str.length();i++){
            if(charsCount[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '#';
    }
}
