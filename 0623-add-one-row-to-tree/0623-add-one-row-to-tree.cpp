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
    TreeNode* addOneRowUtil(TreeNode *root, int val, int depth, int d){
        if(!root) return nullptr;
        
        if(d == depth - 1){
            TreeNode *leftSubtree = root->left;
            TreeNode *rightSubtree = root->right;

            root->left = new TreeNode(val);
            root->right = new TreeNode(val);

            root->left->left = leftSubtree;
            root->right->right = rightSubtree;

            return root;
        }

        root->left = addOneRowUtil(root->left, val, depth, d+1);
        root->right = addOneRowUtil(root->right, val, depth, d+1);

        return root;
    }
public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth == 1){
            TreeNode * newRoot = new TreeNode(val);
            newRoot->left = root;
            return newRoot;
        }
        
        int d = 1;
        return addOneRowUtil(root, val, depth, d);
    }
};