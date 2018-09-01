package com.dream.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class Palindrome {
    public static void main(String[] args){
        String s = "aab";
        partition(s);
    }
    public static ArrayList<ArrayList<String>> partition(String s) {
        int[][] dp = new int[s.length()][s.length()];

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> r = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int k = 0;
                for (; k < (j - i + 1) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) break;
                }

                if (k == (j - i + 1) / 2) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        dfs(0, s, dp, r, result);

        return result;
    }

    private static void dfs(int i, String s, int[][] dp, ArrayList<String> r, ArrayList<ArrayList<String>> result) {
        if (i == s.length()) {
            ArrayList<String> t = new ArrayList<String>(r);
            Collections.reverse(t);
            result.add(t);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j] == 1) {
                r.add(0, s.substring(i, j + 1));
                dfs(j + 1, s, dp, r, result);
                r.remove(0);
            }
        }
    }
}

