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
        if(root == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;
        List<TreeNode> currentLevelNodes = new ArrayList<>();
        currentLevelNodes.add(root);
        while (currentLevelNodes.size() > 0) {
            int levelSum = 0;
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode node : currentLevelNodes) {
                levelSum += node.val;
                if(node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if(node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            if(levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
            currentLevel++;
            currentLevelNodes = nextLevelNodes;
        }
        return maxLevel;
    }
}