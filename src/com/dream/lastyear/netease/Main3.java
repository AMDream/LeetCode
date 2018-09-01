package com.dream.lastyear.netease;

import java.util.Scanner;

/**
 *  输入字符串A，B
 *  将字符串B插入字符串A使产生的字符串是回文字符串
 *  寻找有多少种插入办法
 */
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder(a);
            sb.insert(i,b);
            if (isBack(sb.toString())){
                cnt ++;
            }
        }
        if (isBack(a+b))
            cnt++;
        System.out.println(cnt);
    }
    private static boolean isBack(String str){
        char[] s = str.toCharArray();
        int begin = 0;
        int end = str.length() - 1;
        while (begin < end){
            if (s[begin] != s[end])
                return false;
            begin ++;
            end --;
        }
        return true;
    }
}
