package com.dream.lastyear.tiger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *不改变原数组的前提下，找出最小的K个数
 * 大顶堆
 */
public class Main2 {
    public static void main(String[] args){
        int[] num = {4,5,1,6,2,7,2,8};
        int[] res = findMinK(num,4);
        System.out.println(Arrays.toString(res));
        System.out.println("**********************");
        ArrayList<Integer> resList = GetLeastNumbersInOrder(num,2);
        System.out.println(resList);
    }

    /**
     *最小K个数
     */
    public static int[] findMinK(int[] arr,int k){
        if (k < 1 || k > arr.length)
            return null;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() != k){
                maxHeap.offer(arr[i]);
            }else if (maxHeap.peek() > arr[i]){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        int index = 0;
        for (Integer i : maxHeap) {
            res[index ++] = i;
        }
        return res;
    }
    public static ArrayList<Integer> GetLeastNumbersInOrder(int[] input, int k) {
        ArrayList<Integer> newArr = new ArrayList<>();
        ArrayList<Integer> ori = new ArrayList<>();
        if (k < 1 || k > input.length)
            return newArr;
        for (int i = 0; i < input.length; i++) {
            ori.add(input[i]);
        }
        Arrays.sort(input);
        int max = input[k-1];
        for (int i = 0; i < input.length; i++) {
            if (ori.get(i) <= max && newArr.size() < k){
                newArr.add(ori.get(i));
            }
        }
        return newArr;
    }
}
