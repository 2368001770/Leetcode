package com.niuke.test;

import java.util.ArrayList;
import java.util.List;

public class Source {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //list.add(null);
        System.out.println(list.get(1).equals(null));//always return false,replace equals with ==
    }
}
