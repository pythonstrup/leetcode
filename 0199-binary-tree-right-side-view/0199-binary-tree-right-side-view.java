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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideViews = new ArrayList<Integer>();
        bfs(root, rightSideViews, 0);
        return rightSideViews;
    }

    public void bfs(TreeNode node, List<Integer> rightSideViews, int depth) {
        if (node == null) {
            return;
        }

        if (depth == rightSideViews.size()) {
            rightSideViews.add(node.val);
        }

        bfs(node.right, rightSideViews, depth + 1);
        bfs(node.left, rightSideViews, depth + 1);
    }
}