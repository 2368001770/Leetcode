package com.niuke.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Main33 {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 1){
            return index;
        }
        int i2=0,i3=0,i5=0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while(list.size() < index){
            int min = Math.min(Math.min(2*list.get(i2),3*list.get(i3)),5*list.get(i5));
            list.add(min);
            if(2*list.get(i2) == min){
                i2++;
            }
            if(3*list.get(i3) == min){
                i3++;
            }
            if(5*list.get(i5) == min){
                i5++;
            }
        }
        return list.get(index-1);
    }
}
