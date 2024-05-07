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
    ListNode* doubleIt(ListNode* head) {
        // Reversing the linked list
        ListNode *prev = nullptr, *current = head, *next = nullptr;

        while (current) {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }

        ListNode* newHead = prev;
        ListNode* newHeadTrail = nullptr;

        int doubleValue = 0, carry = 0;
        while (newHead) {
            int num = (newHead->val) * 2 + carry;
            newHead->val = num % 10;
            carry = num / 10;

            newHeadTrail = newHead;
            newHead = newHead->next;
        }
        if (carry) {
            newHeadTrail->next = new ListNode(1);
        }

        current = prev, prev = nullptr, next = nullptr;
        while (current) {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
};
