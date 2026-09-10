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
    int count = 0;

    private int[] calculateAvgNodes(TreeNode root) {
        if (root == null) return new int[] { 0, 0 };

        if (root.left == null && root.right == null) {
            count++;
            return new int[] { root.val, 1 };
        }

        int[] leftValues = calculateAvgNodes(root.left);
        int[] rightValues = calculateAvgNodes(root.right);

        if(root.val == (leftValues[0] + rightValues[0] + root.val) / (leftValues[1] + rightValues[1] + 1)){
            count++;
        }

        return new int[]{leftValues[0] + rightValues[0] + root.val, leftValues[1] + rightValues[1] + 1};

    }

    public int averageOfSubtree(TreeNode root) {
        calculateAvgNodes(root);

        return count;
    }
}