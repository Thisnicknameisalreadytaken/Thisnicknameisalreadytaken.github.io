import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    Map<TreeNode, Integer> y = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> n = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(y.getOrDefault(root, 0), n.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        y.put(root, root.val + n.getOrDefault(root.left, 0) + n.getOrDefault(root.right, 0));
        n.put(root, Math.max(y.getOrDefault(root.left, 0), n.getOrDefault(root.left, 0))
                + Math.max(y.getOrDefault(root.right, 0), n.getOrDefault(root.right, 0)));
    }
}