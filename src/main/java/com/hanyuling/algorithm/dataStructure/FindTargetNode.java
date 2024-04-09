package com.hanyuling.algorithm.dataStructure;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: wrg
 * @date: 2024/3/28 20:44
 */
public class FindTargetNode {

    public static void main(String[] args) {
        FindTargetNode find = new FindTargetNode();
    }

    public int findTargetNode(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(list.size() - k);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
