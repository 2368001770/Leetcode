package com.niuke.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵典藏版礼物。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)。
 */
public class Main46 {
    public int LastRemaining_Solution(int n, int m) {               //用list列表实现
        if(n == 0 || m == 0){               //WARN 注意入参的判断
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1){             //WARN
            index = index + m - 1;
            index = index % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
