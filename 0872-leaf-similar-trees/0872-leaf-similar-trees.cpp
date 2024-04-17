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
    void getLeafNodes(TreeNode *root, string &leafNodes){
        if(!root) return;

        if(!root->left and !root->right) {
            leafNodes += to_string(root->val);
            leafNodes += "_";
        }

        getLeafNodes(root->left, leafNodes);
        getLeafNodes(root->right, leafNodes);
    }
public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        string leafNodes1 = "";
        string leafNodes2 = "";

        getLeafNodes(root1, leafNodes1);
        getLeafNodes(root2, leafNodes2);

        return leafNodes1 == leafNodes2;
    }
};