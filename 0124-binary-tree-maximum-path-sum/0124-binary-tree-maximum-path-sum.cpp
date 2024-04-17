/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */

class Solution {
private:
    int maxPathSumUtil(TreeNode* root, int& maximumSum) {
        if (!root)
            return 0;

        int l = maxPathSumUtil(root->left, maximumSum);
        int r = maxPathSumUtil(root->right, maximumSum);

        if (l < 0)
            l = 0;
        if (r < 0)
            r = 0;

        int sumA = max(l, r) + root->val;
        int sumB = l + r + root->val;

        maximumSum = max(maximumSum, max(sumA, sumB));
        return sumA;
    }

public:
    int maxPathSum(TreeNode* root) {
        int maximumSum = INT_MIN;
        maxPathSumUtil(root, maximumSum);

        return maximumSum;
    }
};