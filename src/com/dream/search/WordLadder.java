package com.dream.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null ||start.equals(end))
            return 0;
        Queue<String> words = new LinkedList<>();
        Queue<Integer> change = new LinkedList<>();
        words.add(start);
        change.add(1);
        while (!words.isEmpty()){
            String curr = words.poll();
            int trans = change.poll();
            for (int i = 0; i < curr.length(); i++) {
                char[] oldW = curr.toCharArray();
                for (char c = 'a'; c <= 'z';c++){
                    oldW[i] = c;
                    String newW = new String(oldW);
                    if (dict.contains(newW)){
                        if (end.equals(newW)){
                            return trans + 1;
                        }
                        words.add(newW);
                        change.add(trans+1);
                        dict.remove(newW);
                    }
                }
            }
        }
        return 0;
    }
}
