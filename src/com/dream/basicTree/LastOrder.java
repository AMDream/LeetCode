package com.dream.basicTree;

import com.dream.support.TreeNode;

import java.util.Stack;

/**
 * 后续遍历
 */
public class LastOrder {
    public void lastOrderRecusively(TreeNode root) {
        if (root != null) {
            lastOrderRecusively(root.left);
            lastOrderRecusively(root.right);
            System.out.println(root.val);
        }
    }
    public void lastOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        TreeNode last = null;
        while (curr != null) {
            s.push(curr);
            curr = curr.left;
        }
        while (!s.empty()){
            curr = s.pop();
            //根节点被访问的条件是：右孩子结点不为空且被访问过
            if (curr.right != null && curr.right != last){  //右孩子结点未被访问过
                s.push(curr);  //重新将该结点入栈
                curr = curr.right;
                while (curr != null){
                    s.push(curr);
                    curr = curr.left;
                }
            }else {
                System.out.println(curr.val);
                last = curr;
            }
        }
    }
}
