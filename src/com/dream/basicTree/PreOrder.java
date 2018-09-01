package com.dream.basicTree;

import com.dream.support.TreeNode;

import java.util.Stack;

/**
 * 先序遍历
 */
public class PreOrder {
    public void preOrderRecusively(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderRecusively(root.left);
            preOrderRecusively(root.right);
        }
    }
    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        while (curr != null || !s.empty()){
            while (curr != null){
                System.out.println(curr.val);
                s.push(curr);
                curr = curr.left;
            }
            if (!s.empty()){
                TreeNode tmp = s.pop();
                curr = tmp.right;
            }
        }
    }
}
