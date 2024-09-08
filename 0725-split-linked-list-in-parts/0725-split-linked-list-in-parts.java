/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Step 2: Calculate the size of each part
        int partSize = length / k;  // The base size of each part
        int extraNodes = length % k; // The number of parts that should have an extra node
        
        // Step 3: Create the result array to store the k parts
        ListNode[] result = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k; i++) {
            result[i] = current;
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0); // Add extra node if necessary
            
            // Step 4: Break the current part
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) current = current.next;
            }
            
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null; // Break the link
                current = nextPart; // Move to the next part
            }
            
            // Reduce the number of extra nodes after using one
            if (extraNodes > 0) extraNodes--;
        }
        
        return result;
    }
}