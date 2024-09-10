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
private:
    int getGCD(int num1, int num2){
        int gcd = 1;
        int itr = 1;
        while(itr <= num1 and itr <= num2){
            if(num1 % itr == 0 and num2 % itr == 0) {
                gcd = itr;
            }
            itr++;
        }

        return gcd;
    }

    int getGCDOptimised(int num1, int num2) {
    while (num2 != 0) {
        int temp = num2;
        num2 = num1 % num2;
        num1 = temp;
    }
    return num1;
}
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if(!head->next) return head;

        ListNode *num1 = head, *num2 = head->next;

        while(num1->next){
            int gcdVal = getGCDOptimised(num1->val, num2->val);
            ListNode *gcd = new ListNode(gcdVal);
            num1->next = gcd;
            gcd->next = num2;
            num1 = num2;
            num2 = num1->next;
        }      
        
        return head;
    }
};