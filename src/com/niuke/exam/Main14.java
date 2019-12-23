package com.niuke.exam;

import java.util.BitSet;
import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] nums = new int[M][2];
        //boolean[] booleans = new boolean[N];
        BitSet bitSet = new BitSet();
        for(int i=0;i<M;i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        int counts = 0;
        int minIndex = 0;
        int maxIndex = 0;
        for(int j=0;j<M;j++){
            minIndex = nums[j][0];
            maxIndex = nums[j][1];
//            for(int k=minIndex;k<=maxIndex;k++){
////                if(booleans[k-1]==false){
////                    booleans[k-1]=true;
////                    counts++;
////                }
//                if(bitSet.get(k)==false){
//                    bitSet.set(k);
//                    counts++;
//                }
//            }
            if(bitSet.get(minIndex)==true&&bitSet.get(maxIndex)==true){
                counts = counts + maxIndex - maxIndex - 1;
            }else if(bitSet.get(minIndex)==true){
                counts = counts + maxIndex - minIndex;
                bitSet.set(maxIndex);
            }else if(bitSet.get(maxIndex)==true){
                counts = counts + maxIndex - minIndex;
                bitSet.set(minIndex);
            }else {
                bitSet.set(minIndex);
                bitSet.set(maxIndex);
                counts = counts + maxIndex - minIndex +1;
            }

            System.out.println(counts);
        }
    }
}
