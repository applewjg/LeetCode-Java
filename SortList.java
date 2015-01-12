/*
 * Author: Yang Pei
 * Problem: Sort List
 * Source: https://oj.leetcode.com/problems/sort-list/
 * 
 * Note:
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Solution:
 * Merge sort.
 */
public class SortList {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head, pre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode temp1 = sortList(head);
        ListNode temp2 = sortList(slow);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(temp1 != null && temp2 != null) {
            if(temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return dummy.next;
    }
}
