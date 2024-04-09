import com.hanyuling.algorithm.dataStructure.TreeNode;
import scala.Int;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String text1 = "abcde", text2 = "ace";
        int i = longestCommonSubsequence(text1, text2);
        System.out.println(i);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(22);
        queue.add(14);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        String a = "2";
        func(a);
        System.out.println(a);
    }
    static void func(String a) {
        a = "3";
    }


    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, p);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return dp[m][n];
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            output.add(nums[i]);
        }
        backTrace(res, output, nums.length, 0);
        return res;
    }

    private static void backTrace(List<List<Integer>> res, List<Integer> output, int length, int first) {
        if (first == length) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < length; i++) {
            Collections.swap(output, i, first);
            backTrace(res, output, length, first + 1);
            Collections.swap(output, i, first);
        }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = null, pre = null;
        dfsTree(root, head, pre);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfsTree(TreeNode cur, TreeNode head, TreeNode pre) {
        if (cur == null) {
            return;
        }
        dfsTree(cur.left, head, pre);
        if (pre != null) {
            pre.right = cur;
        }else {
            head = cur;
        }
        cur.left = pre;
        pre =cur;
        dfsTree(cur.right, head, pre);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount+1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
