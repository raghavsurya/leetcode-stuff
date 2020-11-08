/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Map<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        while(curr != null && curr.next != null) {
            if(map.containsKey(curr.next) && map.get(curr.next).equals(true)) {
                return true;
            }
            curr = curr.next;
            map.put(curr, true);
        }
        return false;
    }
}
