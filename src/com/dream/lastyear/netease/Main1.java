package com.dream.lastyear.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 跳石板问题:贪心算法，每次找最大的因子，如果超过了目标的石板，则回溯，继续计算第二大的因子...
 * 以此类推，找出所有可能的步数，求得其中的最大值
 * ac 20% 算法复杂度太大
 */
public class Main1 {
    private static int max = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        forwardCore(n,m,0);
        System.out.println(max);
    }
    private static void forwardCore(int curr,int target,int step){
        int[] com = findCommon(curr);
        for (int i = com.length - 1; i >= 0; i--) {
            curr += com[i];
            step ++;
            if (curr == target){
                if (step < max){
                    max = step;
                }
                return;
            }
            if (curr < target){
                forwardCore(curr,target,step);
            }
            if (curr > target){
                curr -= com[i];
                step --;
            }
        }
    }
    private static int[] findCommon(int num){
        List<Integer> com = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num) ;i++){
            if (num % i == 0){
                com.add(i);
                if (i != num/i)
                    com.add(num/i);
            }
        }
        int[] c = new int[com.size()];
        for (int i = 0; i < com.size(); i++) {
            c[i] = com.get(i);
        }
        return c;
    }
}
