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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            java.util.Arrays.fill(row, -1);
        }
        
        // Step 2: Extract values from the linked list
        java.util.List<Integer> values = new java.util.ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        // Step 3: Fill the matrix in spiral order
        int index = 0;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Fill top row
            for (int col = left; col <= right; col++) {
                if (index < values.size()) {
                    matrix[top][col] = values.get(index++);
                }
            }
            top++;
            
            // Fill right column
            for (int row = top; row <= bottom; row++) {
                if (index < values.size()) {
                    matrix[row][right] = values.get(index++);
                }
            }
            right--;
            
            if (top <= bottom) {
                // Fill bottom row
                for (int col = right; col >= left; col--) {
                    if (index < values.size()) {
                        matrix[bottom][col] = values.get(index++);
                    }
                }
                bottom--;
            }
            
            if (left <= right) {
                // Fill left column
                for (int row = bottom; row >= top; row--) {
                    if (index < values.size()) {
                        matrix[row][left] = values.get(index++);
                    }
                }
                left++;
            }
        }
        
        return matrix;
    }
}