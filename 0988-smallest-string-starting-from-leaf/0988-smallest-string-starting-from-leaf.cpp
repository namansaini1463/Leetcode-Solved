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
    void smallestFromLeafUtil(TreeNode * root, string &currentString, string &smallestString){
        if(!root) return;

        char ch = (char)(root->val + 'a');
        currentString.insert(currentString.begin(), ch);

        smallestFromLeafUtil(root->left, currentString, smallestString);
        smallestFromLeafUtil(root->right, currentString, smallestString);


        if(!root->left and !root->right){
            if(currentString.size() < smallestString.size() or currentString < smallestString){
                smallestString = currentString;
            }
        }

        currentString.erase(0, 1);
    }
public:
    string smallestFromLeaf(TreeNode* root) {
        string smallestString(8500, 'z');
        string currentString;

        smallestFromLeafUtil(root, currentString, smallestString);

        return smallestString;
    }
};