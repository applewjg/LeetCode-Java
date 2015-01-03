/*
 * Author: Yang Pei
 * Problem: Reverse Linked List II
 * Source: https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Note:
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * Solution:
 * Find the position to start reverse, then reverse the list
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null)
			return head;
		if(m == n)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp1 = head, temp2 = dummy;
		int count = 1;
		while(count < m) {
			temp1 = temp1.next;
			temp2 = temp2.next;
			count++;
		}
		while(count < n) {
			ListNode temp = temp1.next;
			temp1.next = temp.next;
			temp.next = temp2.next;
			temp2.next = temp;
			count++;
		}
		return dummy.next;
	}
}
