package com.dream.catalan;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 卡特兰数：
 * 递归式如下：
 * h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0)
 * (其中n>=2，h(0) = h(1) = 1)
 */
public class Catalan {
    public int catalan(int n){
        if (n <= 1)
            return 1;
        int[] cat = new int[n+1];
        cat[0] = cat[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                cat[i] += cat[j] * cat[i - j - 1];
            }
        }
        int result = cat[n];
        return result;
    }
    /**
     * 应用1：n对括号有多少种匹配方式
     * 思路：第0个符号肯定是左括号，与之匹配的右括号
     * 必须为第2i+1字符。因为如果是第2i个字符，那么第
     * 0个字符与第2i个字符间包含奇数个字符，而奇数个
     * 字符是无法构成匹配的。
     * f(2n)可以转化如下的递推式 f(2n) = f(0)*f(2n-2) + f(2)*f(2n - 4) + ... + f(2n - 4)*f(2) + f(2n-2)*f(0)。
     * 简单解释一下，f(0) * f(2n-2)表示第0个字符与第1个字符匹配，同时剩余字符分成两个部分，一部分为0个字符，
     * 另一部分为2n-2个字符，然后对这两部分求解。
     * f(2)*f(2n-4)表示第0个字符与第3个字符匹配，同时剩余字符分成两个部分，
     * 一部分为2个字符，另一部分为2n-4个字符。
     * f(4) * f(2n - 6)表示第0个字符与第5个字符匹配，同时剩余字符分成两个部分
     * 一部分为4个字符，另一部分为2n-6个字符
     * ....依次类推
     */
    public int kuohaoMatch(int n){
        if (n <= 2)
            return 1;
        int[] f = new int[2 * n + 1];
        f[0] = 1;
        f[2] = 1;
        for (int i = 4; i <= 2 * n ; i+= 2) {
            for (int j = 0; j < i ; j+= 2) {
                f[i] += f[j] * f[i - j - 2];
            }
        }
        return f[2*n];
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString("5 3 0".split(" ")));
    }
}
