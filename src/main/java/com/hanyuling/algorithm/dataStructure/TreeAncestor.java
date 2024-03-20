package com.hanyuling.algorithm.dataStructure;

import java.io.IOException;

public class TreeAncestor {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right || (((root.val == p.val) || (root.val == q.val)) && (left || right))) {
            ans = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }


    public  boolean dfs2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftRes = dfs2(root.left, p, q);
        boolean rightRes = dfs2(root.right, p, q);
        if ((leftRes && rightRes) || ((p.val == root.val || q.val == root.val) && (leftRes || rightRes))) {
            ans = root;
        }
        return leftRes || rightRes || (p.val == root.val || q.val == root.val);
    }


    public boolean dfs3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs3(root.left, p, q);
        boolean right = dfs3(root.right, p, q);
        if ((left && right) || ((p.val == root.val || q.val == root.val) && (left || right))) {
            ans = root;
        }
        return left || right || (p.val == root.val || q.val == root.val);
    }

    class MyException extends Exception{

    }
}
