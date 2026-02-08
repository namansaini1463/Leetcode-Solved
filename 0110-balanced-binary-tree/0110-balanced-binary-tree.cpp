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

    int helper(TreeNode *root){

        if(!root) return 0;

        int leftHeight = helper(root->left); 

        int rightHeight = helper(root->right); 

        if(leftHeight == -1 or rightHeight == -1) return -1;
        if(abs(leftHeight - rightHeight) > 1) return -1; 

        return 1+max(leftHeight, rightHeight);

    }

public:

    bool isBalanced(TreeNode* root) {
        return helper(root) != -1;
    }

};



