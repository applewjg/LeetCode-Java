/*
 * Author: Yang Pei
 * Problem: Merge Two Sorted Lists
 * Source: https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Note:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Solution:
 * Naive method.
 * 
 * Follow up:
 * What if dummy node is not allowed?
 * 		We need to first guarantee the head of the merged list, so we need some
 * 		additional check. We could use recursive method to write it.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode temp1 = l1, temp2 = l2, head = dummy;
		while(temp1 != null && temp2 != null) {
			if(temp1.val < temp2.val) {
				head.next = temp1;
				temp1 = temp1.next;
				head = head.next;
			}
			else {
				head.next = temp2;
				temp2 = temp2.next;
				head = head.next;
			}
		}
		head.next = (temp1 == null) ? temp2 : temp1;
		return dummy.next;
	}
	
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoLists1(l1, l2.next);
			return l2;
		}
	}
}
