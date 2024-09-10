/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        vector<vector<int>> result(m, vector<int>(n, -1));

        int top = 0;
        int bottom = result.size() - 1;
        int left = 0;
        int right = result[0].size() - 1;
        
        while (left <= right && top <= bottom) {
            // Left to right
            for (int i = left; i <= right; i++) {
                if(head){
                    result[top][i] = head->val;
                    head = head->next;
                } else {
                    return result;
                }
            } 
            top++;
            
            // Top to bottom
            for (int i = top; i <= bottom; i++) {
                if(head){
                    result[i][right] = head->val;
                    head = head->next;
                } else {
                    return result;
                }
                
            } 
            right--;
            
            // Right to left, only if there is a remaining row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if(head){
                        result[bottom][i] = head->val;
                        head = head->next;
                    } else {
                        return result;
                    }
                }
                bottom--;
            }
            
            // Bottom to top, only if there is a remaining column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if(head){
                        result[i][left] = head->val;
                        head = head->next;
                    } else {
                        return result;
                    }
                }
                left++;
            }
        }

        return result;
    }
};