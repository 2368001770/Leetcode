package com.niuke.offer;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Main32 {
    public String PrintMinNumber(int [] numbers) {                      //把问题转化为字符串的排序（根据拼接后的字符串排序）
        if(numbers == null || numbers.length == 0){
            return "";
        }
        int length = numbers.length;
        String[] str = new String[length];
        for(int i=0;i<length;i++){
            str[i] = numbers[i] + "";
        }
        Arrays.sort(str, new Comparator<String>() {                   //WARN 字符串数组的排序（若数组类型时int，比较器泛型是Integer，编译报错，需把数组类型转成Integer）
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(str[i]);
        }
        return builder.toString();
    }

    public String PrintMinNumber2(int [] numbers) {
        if(numbers == null && numbers.length == 0){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int num:numbers) {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {                           // WARN 集合排序1
            @Override
            public int compare(Integer o1, Integer o2) {
                return  (o1+""+o2).compareTo(o2+""+o1);
            }
        });
        /*Collections.sort(list, new Comparator<Integer>() {            // WARN 集合排序2
            @Override
            public int compare(Integer o1, Integer o2) {
                return  (o1+""+o2).compareTo(o2+""+o1);
            }
        });*/
        StringBuilder builder = new StringBuilder();
        for (Integer num :list) {
            builder.append(num);
        }
        return builder.toString();
    }
}
