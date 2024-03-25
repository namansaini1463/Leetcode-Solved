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
    
    ListNode* reverseList(ListNode* head) {
    /*
        //? Recursive Solution

        //? Base case
        if(head == nullptr or head->next == nullptr) return head;
        else {
            ListNode *newNode = reverseList(head->next);
            head->next->next = head;
            head->next = nullptr;

            return newNode;
        }
    
    }
    */
    
    //Iterative Solution

        if(head == nullptr or head->next == nullptr) return head;

        ListNode *previous = nullptr;
        ListNode *current = head;
        ListNode *leading = nullptr;

        while(current != nullptr){
            leading = current->next;
            current->next = previous;
            previous = current;
            current = leading;
        }
        head = previous;

        return head;
    }
};