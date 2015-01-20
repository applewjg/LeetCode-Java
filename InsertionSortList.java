/*
 * Author: Yang Pei
 * Problem: Insertion Sort List
 * Source: https://oj.leetcode.com/problems/insertion-sort-list/
 * 
 * Note:
 * Sort a linked list using insertion sort.
 * 
 * Solution:
 * Brute force.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		ListNode temp1 = head, temp2 = null, temp = dummy;
		while(temp1 != null) {
			temp2 = temp1.next;
			temp1.next = null;
			temp = dummy;
			while(temp.next != null && temp.next.val < temp1.val)
				temp = temp.next;
			temp1.next = temp.next;
			temp.next = temp1;
			temp1 = temp2;
		}
		return dummy.next;
	}
}
