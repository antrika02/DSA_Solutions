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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        
        int first = -1;
        int last = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;
        
        while (curr != null && curr.next != null) {
            
            boolean isMax = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMin = curr.val < prev.val && curr.val < curr.next.val;
            
            if (isMax || isMin) {
                
                if (first == -1) {
                    first = index;
                }
                
                if (prevCritical != -1) {
                    minDist = Math.min(minDist, index - prevCritical);
                }
                
                prevCritical = index;
                last = index;
            }
            
            prev = curr;
            curr = curr.next;
            index++;
        }
        
        if (first == last) {
            return new int[]{-1, -1};
        }
        
        return new int[]{minDist, last - first};
    }
}