package com.dream.tree;

import com.dream.support.TreeNode;

/**
 * 判断一棵树的所有节点是否是镜像的，也就是左子树节点与右子树节点中心对称
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricCore(root.left,root.right);
    }
    private boolean isSymmetricCore(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (q.val != p.val)
            return false;
        if (p.val == q.val)
            return isSymmetricCore(p.right,q.right) && isSymmetricCore(p.left,q.left)
            || isSymmetricCore(p.left,q.right) && isSymmetricCore(p.right,q.left);
        return false;
    }
}
