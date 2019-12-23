package com.niuke.importance.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaAndStream {

    //@FunctionalInterface
    interface Operate{
        int add(int a,int b);
        String toString();
        int hashCode();
        boolean equals(Object obj);
        //int a();
    }

    class MathOperate implements Operate{

        @Override
        public int add(int a, int b) {
            return 0;
        }

        public int add(){
            return 1;
        }
    }


    //public static int num = 1;
    public static void main(String[] args) {
        Predicate<String> isEmpty = String::isEmpty;
        Function<String,Integer> toInteger = Integer::valueOf;
        int num = 1;    //不可变（final）
        Operate operate = (a,b) -> num;
        System.out.println(operate.add(1,2));
        System.out.println(num);

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .sorted((a,b) -> b.compareTo(a))
                .filter(a -> a.startsWith("a"))
                .map(String::toUpperCase)
                .map(s -> s+"a")
                .forEach(System.out::println);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        class Person{
            String id;
            String name;
            public Person(String id,String name){
                this.id = id;
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
        //声明一个List集合
        List<Person> list = new ArrayList();
        list.add(new Person("1001", "小A"));
        list.add(new Person("1002", "小B"));
        list.add(new Person("1003", "小C"));
        System.out.println(list);
        //将list转换map
        Map<String, String> map = list.stream().collect(Collectors.toMap(k->k.getId()/*Person::getId*/, Person::getName));
        map.computeIfAbsent("1004",k -> "小D");          //key不存在时执行后面的方法
        map.computeIfPresent("1001",(k,s) -> "小AA");    //key存在时执行后面的方法
        System.out.println(map);
        //原文链接：https://blog.csdn.net/qq_39629277/article/details/83012548
    }
}
