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
    bool isSubPath(ListNode* head, TreeNode* root) {
        if (root == nullptr) return false;  // No tree to search
        
        // Check if the linked list matches starting from the current node
        if (doesPathExist(head, root)) return true;
        
        // Otherwise, recursively check the left and right subtrees
        return isSubPath(head, root->left) || isSubPath(head, root->right);
    }
     bool doesPathExist(ListNode* head, TreeNode* root) {
        if (head == nullptr) return true;  // Reached end of linked list, it's a match
        if (root == nullptr) return false; // Reached a null node, no match
        
        // Check if current node in tree matches current node in linked list
        if (head->val != root->val) return false;
        
        // Recursively check both left and right subtree for the next node in the list
        return doesPathExist(head->next, root->left) || doesPathExist(head->next, root->right);
    }
};