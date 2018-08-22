package com.dream.tree;

import com.dream.support.TreeNode;

/**
 * 将有序数组转换为平衡二叉树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
        return buildTreeCore(num,0,num.length-1);
    }

    private TreeNode buildTreeCore(int[] num, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(num[left]);
        int mid = left + (right - left + 1)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildTreeCore(num,left,mid-1);
        root.right = buildTreeCore(num,mid+1,right);
        return root;
    }
}
