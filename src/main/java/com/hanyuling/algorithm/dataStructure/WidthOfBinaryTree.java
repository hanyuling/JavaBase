package com.hanyuling.algorithm.dataStructure;

import java.util.HashMap;
import java.util.Map;

public class WidthOfBinaryTree {

    int ans ;
    Map<Integer, Integer> left ;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth, int pos) {
        if (node == null) {
            return;
        }
//        left.computeIfAbsent(depth, k -> pos);
        left.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(node.left, depth + 1, pos * 2);
        dfs(node.right, depth + 1, pos * 2 + 1);
    }
}
