/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> clonedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(clonedNodes.containsKey(node)) return clonedNodes.get(node);

        Node clonedNode = new Node(node.val);
        clonedNodes.put(node, clonedNode);

        for(Node adjNode : node.neighbors){
            Node clonedAdjNode = cloneGraph(adjNode);
            clonedNodes.put(adjNode, clonedAdjNode);

            clonedNode.neighbors.add(clonedAdjNode);
        }

        return clonedNode;
    }
}