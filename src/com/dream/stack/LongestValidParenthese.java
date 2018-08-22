package com.dream.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 寻找最长有效括号长度
 * 思路：利用栈，记录符号字符串中(、)的index
 * 1.遇到 ),查看栈顶元素是否是(，如果是则出栈
 * 2.否则，将当前元素index入栈
 * 最终栈中剩下的元素就是不符合括号匹配的符号的位置，在其中寻找相邻index的
 * 最大的差值即为最大长度
 */
public class LongestValidParenthese {
    public static void main(String[] args){
        String str = new Scanner(System.in).nextLine();
        System.out.println(longestValidParentheses(str));
    }
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> sIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !sIndex.empty() && s.charAt(sIndex.peek()) == '(') {
                sIndex.pop();
            } else {
                sIndex.push(i);
            }
        }
        if (sIndex.empty()) {
            return s.length();
        }
        int cnt = s.length();
        int max = 0;
        while (!sIndex.empty()) {
            cnt = cnt - sIndex.peek() - 1;
            max = Math.max(max, cnt);
            cnt = sIndex.peek();
            sIndex.pop();
        }
        max = Math.max(cnt, max);
        return max;
    }
}
