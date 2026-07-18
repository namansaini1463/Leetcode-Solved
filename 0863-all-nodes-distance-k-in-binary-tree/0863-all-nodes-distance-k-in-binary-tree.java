/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void findParentNodes(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(root == null) return;

        map.put(root, parent);

        findParentNodes(root.left, root, map);
        findParentNodes(root.right, root, map);
    }

    private List<Integer> findNodesAtDistanceK(TreeNode target, int k, TreeNode root,  Map<TreeNode, TreeNode> map){
        List<Integer> list = new ArrayList<>();

        if(target == null) return list;
        
        Set<TreeNode> visited = new HashSet<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(target);
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                TreeNode node = q.poll();

                if(distance == k){
                    list.add(node.val);
                }

                if(node != null && map.get(node) != null && !visited.contains(map.get(node))){
                    q.offer(map.get(node));
                    visited.add(map.get(node));
                }

                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);

                }
            }

            distance++;
        }

        return list;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();

        findParentNodes(root, null, map);

        List<Integer> nodesAtDistanceK = findNodesAtDistanceK(target, k, root, map);

        // System.out.println(map);

        return nodesAtDistanceK;
    }
}