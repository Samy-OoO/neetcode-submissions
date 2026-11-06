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
    int getGCD(int x, int y) {
        int g = 1;
        for (int i = 2; i <= min(x, y); i++) {
            if (!(x % i || y % i)) g = i;
        }
        return g;
    }

public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ListNode* cur = head;

        while (cur && cur->next) {
            int g = getGCD(cur->val, cur->next->val);
            ListNode* node = new ListNode(g, cur->next);
            cur->next = node;
            cur = cur->next->next;
        }

        return head;
    }
};