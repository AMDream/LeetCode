package com.dream.tree;

import com.dream.support.TreeNode;

/**
 * 求树的最大深度
 * 通常树的解题思路利用递归
 * 1.如果节点为null，返回0
 * 2.如果是叶子节点，返回1
 * 3.否则，计算其左右子树的最大高度+1即为当前节点的高度
 */
public class MaximumDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(maxDepth(root.left),maxDepth(root.right) + 1);
    }
}
