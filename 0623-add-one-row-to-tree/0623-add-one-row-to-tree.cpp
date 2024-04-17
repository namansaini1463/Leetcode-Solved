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
public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth == 1) {
            TreeNode* newHead = new TreeNode(val);
            newHead -> left = root;
            return newHead;
        }
        queue<TreeNode*> q;
        q.push(root);
        q.push(nullptr);
        int d = 1;
        
        while(d != depth-1){
            auto node = q.front(); q.pop();
            
            if(node){
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            } else {
                if(!q.empty()){
                    q.push(nullptr);
                }
                d++;
            }
        }
            
            while(q.size() > 1){
                auto node = q.front(); q.pop();
                TreeNode* leftSubtree = node->left;
                TreeNode* rightSubtree = node->right;
                
                node->left = new TreeNode(val);
                node->right = new TreeNode(val);
                
                node->left->left = leftSubtree;
                node->right->right = rightSubtree;
            }
        

        
        return root;
    }
};