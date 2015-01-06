/*
 * Author: Yang Pei
 * Problem: Reorder List
 * Source: https://oj.leetcode.com/problems/reorder-list/
 * 
 * Note:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Solution:
 * First find the length of the list, then split the list in two half, then 
 * reverse the second half and merge the two list.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return;
		int count = 0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		int half = count / 2;
		temp = head;
		while(half > 1) {
			temp = temp.next;
			half--;
		}
		ListNode head2 = temp.next;
		temp.next = null;
		ListNode dummy = new ListNode(0);
		dummy.next = head2;
		while(head2.next != null) {
			temp = head2.next;
			head2.next = temp.next;
			temp.next = dummy.next;
			dummy.next = temp;
		}
		ListNode head1 = head; head2 = dummy.next;
		dummy.next = null; head = dummy;
		while(head1 != null) {
			head.next = head1;
			head = head.next;
			head1 = head1.next;
			head.next = head2;
			head = head.next;
			head2 = head2.next;
		}
		head.next = head2;
		head = dummy.next;
	}
}
