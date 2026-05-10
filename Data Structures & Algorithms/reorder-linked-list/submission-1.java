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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        //now we have two halves head and mid
        //reversing mid

        ListNode curr = mid;
        prev = null;

        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        //now the two linked lists are prev and head
        //merging them 

        ListNode l1 = head;
        ListNode l2 = prev;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(l1!=null && l2!=null)
        {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        
        if(l1!=null)
        {
            tail.next = l1;
        }
        else if(l2!=null)
        {
            tail.next = l2;
        }
    }
}
