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
    TreeNode * deleteNodesHelper(TreeNode* root, unordered_set<int> &st, vector<TreeNode *> &result){
        if(!root) return nullptr;

        root->left = deleteNodesHelper(root->left, st, result);
        root->right = deleteNodesHelper(root->right, st, result);

        if(st.find(root->val) != st.end()){
            if(root->left){
                result.push_back(root->left);
            }
            if(root->right){
                result.push_back(root->right);
            }
            return nullptr;
        } else {
            return root;
        }
    }
public:
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        vector<TreeNode *> result;

        unordered_set<int> st;
        for(const auto &n : to_delete){
            st.insert(n);
        }

        deleteNodesHelper(root, st, result);

        if(st.find(root->val) == st.end()){
            result.push_back(root);
        }

        return result;
    
    }
};