package com.dream.lastyear.netease;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 操作的逆向：先将队列中的队尾元素放置到队头，然后顺序取下一个元素放置到队头
 * https://www.nowcoder.com/practice/657d09e2b3704574814089ba8566d98d?tpId=85&tqId=29849&tPage=3&rp=3&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            BuildOriginQueue(n);
        }
    }
    private static void BuildOriginQueue(int n) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            q.addFirst(i);
            //取出队尾
            int tail = q.removeLast();
            //放到队头
            q.addFirst(tail);
        }
        /*
        这样遍历输出会超时，因为linkedList的get(i)的时间复杂度是O(n)
        AC 90%  因为算法复杂度过高
        for (int i = 0; i < q.size() - 1;i++){
            System.out.print(q.get(i) + " ");
        }
        System.out.println(q.get(q.size() - 1));*/
        //先记录下长度
        int len = q.size();
        for (int i = 0; i < len - 1;i++){
            //removeFirst时间复杂度是O(1)
            System.out.print(q.removeFirst() + " ");
        }
        System.out.println(q.removeFirst());
    }
}
