package com.dream.lastyear.gowhere;

import java.util.*;

/**
 *给定一个英文字符串,请写一段代码找出这个字符串中
 * 首先出现三次的那个英文字符(需要区分大小写)。
 * 注意：找英文字符
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!( c <= 'z' && c >= 'a' || c >= 'A' && c <= 'Z'))
                continue;
            if (map.get(c) != null){
                int cnt = map.get(c);
                if (cnt == 2){
                    System.out.println(c);
                    return;
                }else{
                    map.put(c,cnt + 1);
                }
            }else{
                map.put(c,1);
            }
        }
    }
}
