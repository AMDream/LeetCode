package com.dream.basicTree;

import com.dream.support.TreeNode;

import java.util.Stack;

/**
 * 中序遍历
 */
public class InOrder {
    public void inOrderRecursively(TreeNode root){
        if (root != null){
            inOrderRecursively(root.left);
            System.out.println(root.val);
            inOrderRecursively(root.right);
        }
    }
    public void inOrder(TreeNode root){
        if (root == null)
            return;
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        while (curr != null || !s.empty()){
            while (curr != null){
                s.push(curr);
                curr = curr.left;
            }
            if (!s.empty()){
                TreeNode tmp = s.pop();
                System.out.println(tmp.val);
                curr = tmp.right;
            }
        }
    }
}
