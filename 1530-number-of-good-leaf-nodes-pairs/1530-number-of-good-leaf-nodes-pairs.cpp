/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    void findLeafNodes(TreeNode * root, unordered_set<TreeNode *> &leafNodes){
        if(!root) return;

        findLeafNodes(root->left, leafNodes);
        findLeafNodes(root->right, leafNodes);

        if(!root->left and !root->right){
            leafNodes.insert(root);
        }
    }

    void convertTreeToGraph(TreeNode *root, unordered_map<TreeNode *, vector<TreeNode *>> &treeGraph){
        if(!root) return;

        if(root->left){
            treeGraph[root].push_back(root->left);
            treeGraph[root->left].push_back(root);
        }

        if(root->right){
            treeGraph[root].push_back(root->right);
            treeGraph[root->right].push_back(root);
        }

        convertTreeToGraph(root->left, treeGraph);
        convertTreeToGraph(root->right, treeGraph);
    }
public:
    int countPairs(TreeNode *root, int distance) {
        // Finding all the leaf nodes and storing them in a set
        unordered_set<TreeNode *> leafNodes;
        findLeafNodes(root, leafNodes);

        // Converting the tree into an undirected graph
        unordered_map<TreeNode *, vector<TreeNode *>> treeGraph;
        convertTreeToGraph(root, treeGraph);

        // Variable to store the count of good pairs
        int goodPairsCount = 0;

        // Applying BFS to each leaf node in the graph to find the good nodes
        for (const auto &leafNode : leafNodes) {
            queue<TreeNode *> q;
            q.push(leafNode);
            unordered_map<TreeNode *, int> visited;
            visited[leafNode] = 0;

            while (!q.empty()) {
                TreeNode *current = q.front();
                q.pop();

                int currentDistance = visited[current];

                if (currentDistance > distance) {
                    break;
                }

                for (const auto &adj : treeGraph[current]) {
                    if (visited.find(adj) == visited.end()) {
                        visited[adj] = currentDistance + 1;
                        q.push(adj);
                        if (leafNodes.find(adj) != leafNodes.end() && adj != leafNode) {
                            if (visited[adj] <= distance) {
                                goodPairsCount++;
                            }
                        }
                    }
                }
            }
        }

        // Each pair is counted twice, so divide the result by 2
        return goodPairsCount / 2;
    }
};