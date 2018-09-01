package com.dream.lastyear.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 动态规划
 * 从i 开始跳，假设可以跳j步，那么mark[i+j] = min(mark[i]+1,mark[i+j])  //状态转移表达式
 */
public class Main11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] mark = new int[m + 1];
        //初始化设置为Integer.MAX_VALUE
        Arrays.fill(mark,Integer.MAX_VALUE);
        //起跳石板处步数为0
        mark[n] = 0;
        for (int i = n; i < m - 1 ; i++) {
            if (mark[i] == Integer.MAX_VALUE)
                continue;
            List<Integer> factors = getFactors(i);
            for (int j = 0; j < factors.size(); j++) {
                //可以跳跃的石板数
               int currStep = factors.get(j);
               //跳跃到下一个石板的编号
               int nextStone = i + currStep;
                //跳跃到nextStep所需要的步数
               int step = mark[i] + 1;
               if (nextStone <= m && step < mark[nextStone]){
                   mark[nextStone] = step;
               }
            }
        }
        if (mark[m] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(mark[m]);
    }

    private static List<Integer> getFactors(int num) {
        List<Integer> facs = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                facs.add(i);
                if (i != num/i){
                    facs.add(num/i);
                }
            }
        }
        return facs;
    }
}
