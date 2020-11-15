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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1 != null || l2 != null) {
            int l1Value = 0;
            int l2Value = 0;
            l1Value = l1 != null ? l1.val: l1Value; //2
            l2Value = l2 != null ? l2.val: l2Value; //1
            if(l1 != null && l2 != null) {
                if(l1.val == l2.val) {
                    curr.next = new ListNode(l1Value);
                    curr.next.next = new ListNode(l2Value);
                    curr = curr.next.next;
                    l1 = l1.next;
                    l2 = l2.next;
                } else if(l1.val > l2.val) {
                    curr.next = new ListNode(l2.val);
                    curr = curr.next;
                    l2 = l2.next;
                } else {
                     curr.next = new ListNode(l1.val);
                    curr = curr.next;
                    l1 = l1.next;
                }
            } else if(l1 != null) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 = l1.next;
            } else {
               curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2 = l2.next;
                
            }
        }
        return dummyHead.next;
    }
}
