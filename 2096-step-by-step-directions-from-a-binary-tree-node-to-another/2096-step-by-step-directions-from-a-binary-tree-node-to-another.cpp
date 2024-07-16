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
    TreeNode * findLCA(TreeNode * root, int src, int dst){
        if(!root) return nullptr;

        if(root->val == src or root->val == dst) return root;

        TreeNode *left = findLCA(root->left, src, dst);
        TreeNode *right = findLCA(root->right, src, dst);

        if(left and right) return root;
 
        return left ? left  : right;
    }

    bool findPath(TreeNode * LCA, int targetValue, string &path){
        if(!LCA) return false;

        if(LCA->val == targetValue) return true;

        path.push_back('L');
        if(findPath(LCA->left, targetValue, path)){
            return true;
        }
        path.pop_back();

        path.push_back('R');
        if(findPath(LCA->right, targetValue, path)){
            return true;
        }
        path.pop_back();

        return false;
    }
public:
    string getDirections(TreeNode* root, int startValue, int destValue) {
        TreeNode * LCA = findLCA(root, startValue, destValue);

        string LCAToStartValue = "";
        string LCAToDestValue = "";

        findPath(LCA, startValue, LCAToStartValue);
        findPath(LCA, destValue, LCAToDestValue);

        int len = LCAToStartValue.size();
        string startValueToLCA ="";
        for(int i = 0; i < len; i++){
            startValueToLCA += 'U';
        }

        return startValueToLCA + LCAToDestValue;

    }
};