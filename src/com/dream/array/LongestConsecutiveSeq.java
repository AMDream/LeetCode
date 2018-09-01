package com.dream.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个无序数组，寻找其中最长的连续数字序列，时间复杂度为O(n)
 * 将所有元素保存在set中，然后依次遍历其中的每个元素，
 * 并删除该元素前后连续的数字，记录删掉的数字即为当前的连续序列长度
 */
public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] num) {
        if (num == null)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (Integer i:num) {
            set.add(i);
        }
        int max = 1;
        for (Integer n : num) {
            if (set.remove(n)){
                int curr = n;
                int sum = 1;
                int curr_small = curr - 1;
                int curr_big = curr + 1;
                while (set.remove(curr_small)){
                    sum ++;
                    curr_small --;
                }
                while (set.remove(curr_big)){
                    sum ++;
                    curr_big ++;
                }
                max = Math.max(0,sum);
            }
        }
        return max;
    }
}
