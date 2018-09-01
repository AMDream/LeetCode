package com.dream.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解某个数的因子，不包括1和它本身
 */
public class GetFactors {
    public static void main(String[] args){
        List<Integer> res = getFactors2(12);
        System.out.println(res);
    }

    /**
     * 此种方式计算所有因子可能会造成世间复杂度过大
     */
    public static List<Integer> getFactors(int num){
        List<Integer> facs = new ArrayList<>();
        for (int i = 2; i <= num/2 ; i++) {
            if (num % i == 0)
                facs.add(i);
        }
        return facs;
    }

    /**
     * 计算因子，每次同时求得一对因子
     */
    public static List<Integer> getFactors2(int num){
        List<Integer> facs = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0){
                facs.add(i);
                if (i != num/i)
                    facs.add(num/i);
            }
        }
        return facs;
    }
}
