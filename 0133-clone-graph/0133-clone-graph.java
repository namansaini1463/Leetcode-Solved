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
    public Node cloneGraph(Node node) {
        Map<Node, Node> clonedNodes = new HashMap<>();

        if(Objects.isNull(node)) return null;

        Node clonedRootNode = new Node(node.val);
        clonedNodes.put(node, clonedRootNode);

        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node n = q.poll();

            for(Node adjNode : n.neighbors){
                if(!clonedNodes.containsKey(adjNode)){
                    Node clonedAdjNode = new Node(adjNode.val);
                    q.offer(adjNode);

                    clonedNodes.put(adjNode, clonedAdjNode);
                }

                clonedNodes.get(n).neighbors.add(clonedNodes.get(adjNode));
            }
        }

        return clonedNodes.get(node);
    }
}