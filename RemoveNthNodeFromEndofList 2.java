/*
 * Author: Yang Pei
 * Problem: Remove Nth Node From End of List
 * Source: https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Note:
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * Solution: 
 * 		Use two pointers.
 * 		Use recursive method.
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp1 = head;
		while(n > 0) {
			temp1 = temp1.next;
			n--;
		}
		ListNode temp2 = head, pre = null;
		while(temp1 != null) {
			temp1 = temp1.next;
			pre = temp2;
			temp2 = temp2.next;
		}
		if(pre == null)
			return temp2.next;
		pre.next = temp2.next;
		return head;
	}
	
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		recurse(dummy, n);
		return dummy.next;
	}
	
	private int recurse(ListNode head, int n) {
		if(head == null)
			return 0; 
		int ind = recurse(head.next, n) + 1;
		if(ind == n + 1)
			head.next = head.next.next;
		return ind;
	}
}
