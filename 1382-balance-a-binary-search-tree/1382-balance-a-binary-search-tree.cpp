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
    void getInorderTraversal(TreeNode * root, vector<int> &inorder){
        //Traversing the left subtree
        if(root->left){
            getInorderTraversal(root->left, inorder);   
        } 
        
        inorder.push_back(root->val);
        
        //Traversing the right subtree
        if(root->right){
            getInorderTraversal(root->right, inorder);
        }
    }
    
    TreeNode * buildTree(int left, int right, vector<int> &inorder){
        if(left > right) return nullptr;
        
        int mid = left + (right - left)/2;
        
        TreeNode *newNode = new TreeNode(inorder[mid]);
        newNode->left = buildTree(left, mid-1, inorder);
        newNode->right = buildTree(mid+1, right, inorder);
        
        return newNode;
        
    }
public:
    TreeNode* balanceBST(TreeNode* root) {
        //Finding the inorder traversal of the tree and storing it in an array
        vector<int> inorder;
        getInorderTraversal(root, inorder);
        
        root = buildTree(0, inorder.size()-1, inorder);
        
        return root;
    }
};