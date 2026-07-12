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
    List<List<Integer>> result;
    List<Integer> currentPath;

    public boolean getPaths(TreeNode root, int targetSum){
        if (root == null) return false;

        currentPath.addLast(root.val);

        if(root.val == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(currentPath));
            currentPath.removeLast();
            return true;
        }


        boolean hasOnLeft = getPaths(root.left, targetSum - root.val);
        boolean hasOnRight= getPaths(root.right, targetSum - root.val);

        currentPath.removeLast();

        return hasOnLeft || hasOnRight;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        
        this.currentPath = new LinkedList<>();

        getPaths(root, targetSum);
        

        return result;
    }
}