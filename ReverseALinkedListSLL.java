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
    public ListNode reverseList(ListNode head) {
       if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next; //2
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

//TC: O(N)
//SC: O(1)
