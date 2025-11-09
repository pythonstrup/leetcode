/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> sums = new HashMap<>();
        bfs(root, sums, 1);
        return sums.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    private void bfs(TreeNode node, Map<Integer, Integer> sums, int depth) {
        if (node == null) {
            return;
        }

        sums.put(depth, sums.getOrDefault(depth, 0) + node.val);

        bfs(node.left, sums, depth + 1);
        bfs(node.right, sums, depth + 1);
    }
}